package edu.bethlehem.Geojson;

import java.util.HashMap;

public class Path {
	String type = "Feature";
	Geometry geometry;
	HashMap<String, String> properties;

	public Path() {
		geometry = new Geometry();
		properties = new HashMap<String, String>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}

	public void addProperties(String key, String value) {
		properties.put(key, value);
	}
}