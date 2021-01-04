package edu.bethlehem.Graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.bethlehem.Geojson.Geojson;

public class Dijkstra {

	Hashtable<Long, SearchNode> nodeList = new Hashtable<Long, SearchNode>();
	ArrayList<Long> parents;

	void addNodes(Graph graph) {
		graph.getNodes().forEach((key, Node) -> {
			SearchNode tmpNode = new SearchNode(key, graph.getNodes().get(key).getLat(),
					graph.getNodes().get(key).getLon());

			nodeList.put(key, tmpNode);

		});

	}

	void addCost(Graph graph) {
		graph.getNodes().forEach((key, Node) -> {
			int numofedges = graph.getNodes().get(key).getEdges().size();
			for (int i = 0; i < numofedges; i++) {

				long dst = graph.getNodes().get(key).getEdges().get(i).getDestinationNodeId();
				nodeList.get(key).getNeighbors().add(nodeList.get(dst));
				nodeList.get(key).getCostedNodes().put(nodeList.get(dst),
						graph.getNodes().get(key).getEdges().get(i).getCost());
			}

		});
	}

	void dijkstra(Graph graph, long sourceId, long distId) throws JsonProcessingException {
		addNodes(graph);
		addCost(graph);
		nodeList.get(sourceId).setCost(0);
		PriorityQueue<SearchNode> queue = new PriorityQueue<>();

		nodeList.forEach((key, Node) -> {
			queue.add(Node);

		});

		while (!queue.isEmpty()) {
			SearchNode presentNode = queue.remove();
			// if (presentNode.getNodeId() != distId) {
			for (SearchNode neighbor : presentNode.getNeighbors()) {
				if (queue.contains(neighbor)) {

					if (neighbor.getCost() > (presentNode.getCost() + presentNode.getCostedNodes().get(neighbor))) {

						neighbor.setCost((presentNode.getCost() + presentNode.getCostedNodes().get(neighbor)));
						neighbor.setParent(presentNode);
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
			// }
		}

		print(sourceId, distId);
		Geojson g = new Geojson(graph, parents);
		System.out.println(g.getJeoJson());
	}

	private void print(long srcId, long distId) {
		SearchNode Node = nodeList.get(distId);
		System.out.print("path from node " + srcId + " to Node " + Node.getNodeId() + " distance: " + Node.getCost()
				+ " Path: ");
		pathPrintStore(Node);
		System.out.println(" ");

	}

	private void pathPrintStore(SearchNode node) {

		parents = new ArrayList<Long>();

		if (node.getParent() != null) {
			pathPrintStore(node.getParent());
			System.out.print(" \n to node  " + node.nodeId);

		} else
			System.out.print(node.nodeId);
		parents.add(node.nodeId);

	}

}
