package com.asthon.taxi.app.model;

public class BoundingBox {
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