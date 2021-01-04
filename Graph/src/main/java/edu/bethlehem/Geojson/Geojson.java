package edu.bethlehem.Geojson;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.bethlehem.Graph.Graph;
import edu.bethlehem.Graph.Node;

public class Geojson {
	Graph graph;
	ArrayList<Long> nodesPath;
	ObjectMapper mapper = new ObjectMapper();

	public Geojson(Graph graph, ArrayList<Long> nodesPath) {
		this.nodesPath = nodesPath;
		this.graph = graph;
	}

	public String getJeoJson() throws JsonProcessingException {
		Path path = new Path();
		Geometry geometry = new Geometry();
		for (long nodeId : nodesPath) {
			Node node = graph.getNodes().get(nodeId);
			double lon = node.getLon();
			double lat = node.getLat();
			geometry.addCoordinates(lon, lat);
		}
		path.setGeometry(geometry);

		return mapper.writeValueAsString(path);

	}
}
