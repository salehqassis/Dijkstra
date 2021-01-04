package edu.bethlehem.Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	long nodeId;
	String nodeName;
	float lat, lon;
	public List<Edge> edges;


		public Node(long nodeId, String nodeName, float lat, float lon) {
		setNodeId(nodeId);
		setNodeName(nodeName);
		setLat(lat);
		setLon(lon);
		edges = new ArrayList<Edge>();
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public String toString() {
		return "Node [nodeId=" + nodeId + ", nodeName=" + nodeName + ", lat=" + lat + ", lon=" + lon + ", edges="
				+ edges.toArray().toString() + "]";
	}

}
