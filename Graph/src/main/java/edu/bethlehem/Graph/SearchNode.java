package edu.bethlehem.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchNode implements Comparable<SearchNode> {
	public long nodeId;

	private ArrayList<SearchNode> neighbors = new ArrayList<SearchNode>();
	private HashMap<SearchNode, Integer> costedNodes = new HashMap<>();
//	private boolean isVisited = false;
	private SearchNode parent;
	private int cost;
	float lat, lon;

	public SearchNode(long nodeId, float lat, float lon) {
		this.nodeId = nodeId;
		this.lat = lat;
		this.lon = lon;
		cost = Integer.MAX_VALUE;
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public ArrayList<SearchNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<SearchNode> neighbors) {
		this.neighbors = neighbors;
	}

	public HashMap<SearchNode, Integer> getCostedNodes() {
		return costedNodes;
	}

	public void setCostedNodes(HashMap<SearchNode, Integer> costedNodes) {
		this.costedNodes = costedNodes;
	}
	

	public SearchNode getParent() {
		return parent;
	}

	public void setParent(SearchNode parent) {
		this.parent = parent;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(SearchNode o) {
		return this.cost - o.cost;
	}
}