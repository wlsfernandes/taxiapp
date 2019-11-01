package com.asthon.taxi.app.maps.model;

public class Options {
	 private float maxResults;
	 private boolean thumbMaps;
	 private boolean ignoreLatLngInput;


	 // Getter Methods 

	 public float getMaxResults() {
	  return maxResults;
	 }

	 public boolean getThumbMaps() {
	  return thumbMaps;
	 }

	 public boolean getIgnoreLatLngInput() {
	  return ignoreLatLngInput;
	 }

	 // Setter Methods 

	 public void setMaxResults(float maxResults) {
	  this.maxResults = maxResults;
	 }

	 public void setThumbMaps(boolean thumbMaps) {
	  this.thumbMaps = thumbMaps;
	 }

	 public void setIgnoreLatLngInput(boolean ignoreLatLngInput) {
	  this.ignoreLatLngInput = ignoreLatLngInput;
	 }
	}