package edu.bethlehem.Graph;

import java.util.Hashtable;
import java.util.List;


public class Graph {
	int numberOfNodes;
	int numberOfEdges=0;

	Hashtable<Long, Node> nodes = new Hashtable<Long, Node>();

	public Graph() {
		nodes = new Hashtable<Long, Node>();
	}

	public void addNode(Long nodeId, String name, float lat, float lon) {
		Node node = new Node(nodeId, name, lat, lon);
		nodes.put( nodeId, node);
		numberOfNodes++;
		
	}


	public void addEdge(long source, long destination, String name, int cost, int distance, boolean biDirectional) {
		nodes.get(source).addEdge(new Edge(destination, name, cost, distance));
		numberOfEdges++;
		if (biDirectional) {
			nodes.get(destination).addEdge(new Edge(source,name,cost,distance));
			numberOfEdges++;
		}
		
		
		
	}


	public List<Edge> getEdges(long nodeId) {
		return nodes.get(nodeId).getEdges();
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	
	public Hashtable<Long, Node> getNodes() {
		return nodes;
	}

	

	@Override
	public String toString() {
		return "Graph [numberOfNodes=" + numberOfNodes + ", numberOfEdges=" + numberOfEdges + ", nodes=" + nodes + "]";
	}

}

