package com.asthon.taxi.app.maps.model;

import java.io.Serializable;

public class BoundingBox implements Serializable {

	private static final long serialVersionUID = -5079705255944409024L;
	
      Lr LrObject;
	  Ul UlObject;


	 // Getter Methods 

	  public Lr getLr() {
	    return LrObject;
	  }

	  public Ul getUl() {
	    return UlObject;
	  }

	 // Setter Methods 

	  public void setLr( Lr lrObject ) {
	    this.LrObject = lrObject;
	  }

	  public void setUl( Ul ulObject ) {
	    this.UlObject = ulObject;
	  }
	}