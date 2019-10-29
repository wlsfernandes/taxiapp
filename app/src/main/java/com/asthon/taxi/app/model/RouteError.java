package com.asthon.taxi.app.model;


public class RouteError {
	  
	private float errorCode;
	  private String message;


	 // Getter Methods 

	  public float getErrorCode() {
	    return errorCode;
	  }

	  public String getMessage() {
	    return message;
	  }

	 // Setter Methods 

	  public void setErrorCode( float errorCode ) {
	    this.errorCode = errorCode;
	  }

	  public void setMessage( String message ) {
	    this.message = message;
	  }
	}