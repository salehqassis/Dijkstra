package edu.bethlehem.Graph;

public class Edge {
	long destinationNodeId;
	long sourceNodeId;
	String name;
	int cost;
	int distance;
	public Edge(long source) {
		setDestinationNodeId(source);
	}

	public Edge(long destinationNodeId, String name, int cost, int distance) {
		setDestinationNodeId(destinationNodeId);	
		setName(name);
		setCost(cost);
		setDistance(distance);
	}

	public long getDestinationNodeId() {
		return destinationNodeId;
	}

	public void setDestinationNodeId(long destinationNodeId) {
		this.destinationNodeId = destinationNodeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Edge [destinationNodeId= " + destinationNodeId + ", name= " + name + ", cost= " + cost +
				", distance= " + distance + "]";
	}

}
