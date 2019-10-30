package com.asthon.taxi.app.maps.model;

import java.io.Serializable;

public class DisplayLatLng implements Serializable {
	 
	private static final long serialVersionUID = 4613464947321151248L;
	
	private Double lng;
	private Double lat;
	 
	 
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}


}