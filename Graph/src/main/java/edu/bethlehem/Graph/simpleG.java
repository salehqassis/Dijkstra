package edu.bethlehem.Graph;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class simpleG {
	
	static String pathname = "src\\main\\java\\edu\\bethlehem\\Graph\\Bethlehem-small.xml";
	//static Graph g = new Graph();
	static long nodeId;
	Hashtable<Long, SearchNode> srchNodes = new Hashtable<>();

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Graph graph = XmlReader.createGraph(pathname);
		Scanner input = new Scanner(System.in);
		// System.out.println(graph.getNodes());
	/*	g.addNode((long) 1, "A", 0, 0);
		g.addNode((long) 2, "B", 1, 1);
		g.addNode((long) 3, "C", 2, 2);
		g.addNode((long) 4, "D", 3, 3);
		g.addNode((long) 5, "E", 4, 4);
		g.addNode((long) 6, "F", 5, 5);
		g.addNode((long) 7, "G", 6, 6);

		g.addEdge(1, 2, "1", 2, 2, true);
		g.addEdge(1, 3, "2", 0, 0, true);
		g.addEdge(1, 4, "3", 1, 1, true);
		g.addEdge(2, 4, "4", 3, 3, true);
		g.addEdge(2, 5, "5", 10, 10, true);
		g.addEdge(3, 4, "6", 2, 2, true);
		g.addEdge(3, 6, "7", 1, 1, true);
		g.addEdge(4, 5, "8", 2, 2, true);
		g.addEdge(4, 6, "9", 8, 8, true);
		g.addEdge(4, 7, "10", 4, 4, true);
		g.addEdge(5, 7, "11", 6, 6, true);
		g.addEdge(6, 7, "12", 1, 1, true);*/
		Dijkstra algo = new Dijkstra();
	//	nodes for input 
//288189326
//431622919
//431629971	
		System.out.println(" please enter a node src");
		long src = input.nextLong();
		System.out.println(" please enter a node dst");

		long dst = input.nextLong();
		algo.dijkstra(graph, src, dst);
		// algo.dijkstra(g, 1, 7);
		// algo.dijkstra(g, 1, 4);
System.out.println("copy the geojson to (https://geojson.io/)");
	}
	/*
	 * static long getNodeId(Graph graph, float lat, float lon) {
	 * 
	 * graph.getNodes().forEach((key, Node) -> { if
	 * (graph.getNodes().get(key).getLat() == lat) ; if
	 * (graph.getNodes().get(key).getLon() == lon) {
	 * 
	 * nodeId = graph.getNodes().get(key).getNodeId();
	 * 
	 * } }); return nodeId;
	 * 
	 * }
	 */

}
