package edu.bethlehem.Geojson;

import java.util.ArrayList;

public class Geometry {
	String type = "LineString";
	ArrayList<ArrayList<Double>> coordinates;

	public Geometry() {
		coordinates = new ArrayList<ArrayList<Double>>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<ArrayList<Double>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<ArrayList<Double>> coordinates) {
		this.coordinates = coordinates;
	}

	public void addCoordinates(double lon, double lat) {
		ArrayList<Double> coords = new ArrayList<Double>();
		coords.add(lon);
		coords.add(lat);
		coordinates.add(coords);
	}
}
