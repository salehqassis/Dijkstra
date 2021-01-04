package edu.bethlehem.Graph;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.geotools.referencing.GeodeticCalculator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReader {

	public static void main(String[] args) throws Exception {

		/*String pathname = null ;
		Graph graph = createGraph(pathname);
		System.out.println("number of nodes " + graph.getNumberOfNodes());
		System.out.println("number of edges " + graph.getNumberOfEdges() / 2);
		System.out.println(graph.getEdges(431623511));*/
	}

	public static Graph createGraph(String pathname) throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File(pathname);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		NodeList nList = doc.getElementsByTagName("node");
		Graph graph = new Graph();

		int length = nList.getLength();
		for (int i = 0; i < length; i++) {
			Element elementNode = (Element) nList.item(i);

			graph.addNode(Long.parseLong((elementNode.getAttribute("id"))), "",
					Float.parseFloat(elementNode.getAttribute("lat")),
					Float.parseFloat(elementNode.getAttribute("lon")));

		}

		NodeList ways = doc.getElementsByTagName("way");
		for (int i = 0; i < ways.getLength(); i++) {
			Element elementWay = (Element) ways.item(i);
			NodeList wayNodes = elementWay.getElementsByTagName("nd");
			double speedMS = getSpeedKMH(elementWay) * 1000 / 3600.0;
			for (int j = 1; j < wayNodes.getLength(); j++) {
				Element prevWayNodeElement = (Element) wayNodes.item(j - 1);
				Element wayNodeElement = (Element) wayNodes.item(j);
				long source = Long.parseLong((wayNodeElement.getAttribute("ref")));
				long destination = Long.parseLong((prevWayNodeElement.getAttribute("ref")));
				int orthodromicDist = getOrthodromicDist(graph.getNodes().get(source).getLat(),
						graph.getNodes().get(source).getLon(), graph.getNodes().get(destination).getLat(),
						graph.getNodes().get(destination).getLon());
				int timeInSec = (int) (orthodromicDist / speedMS);
				graph.addEdge(source, destination, "", timeInSec, orthodromicDist, true);

			}

		}
		return graph;
	}

	private static int getSpeedKMH(Element elementWay) {
		NodeList tags = elementWay.getElementsByTagName("tag");
		for (int j = 0; j < tags.getLength(); j++) {
			Element wayTagItem = (Element) tags.item(j);
			if (wayTagItem.getAttribute("k").equals("highway")) {
				switch (wayTagItem.getAttribute("v").toLowerCase().trim()) {
				case "motorway":
					return 120;
				case "primary":
					return 80;
				case "secondary":
					return 50;
				case "tertiary ":
					return 40;
				case "residential":
					return 20;
				default:
					return 30;
				}
			}
		}
		return 30;
	}

	private static int getOrthodromicDist(float srcLat, float srcLon, float dstLat, float dstLon) {
		GeodeticCalculator calculator = new GeodeticCalculator();
		calculator.setStartingGeographicPoint(srcLon, srcLat);
		calculator.setDestinationGeographicPoint(dstLon, dstLat);
		return (int) calculator.getOrthodromicDistance();
	}
}