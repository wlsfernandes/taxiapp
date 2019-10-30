package com.asthon.taxi.app.maps.model;

import java.io.Serializable;

public class Lr implements Serializable {
	
	private static final long serialVersionUID = 1305761480847056947L;

	private float lng;
	  private float lat;


	 // Getter Methods 

	  public float getLng() {
	    return lng;
	  }

	  public float getLat() {
	    return lat;
	  }

	 // Setter Methods 

	  public void setLng( float lng ) {
	    this.lng = lng;
	  }

	  public void setLat( float lat ) {
	    this.lat = lat;
	  }
	}