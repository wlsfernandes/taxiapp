package com.asthon.taxi.app.maps.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {

	
	ArrayList<Results> results = new ArrayList<Results>();

	public ArrayList<Results> getResults() {
		return results;
	}

	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}
	
	
	
	
	
}
