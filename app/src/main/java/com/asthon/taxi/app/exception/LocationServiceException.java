package com.asthon.taxi.app.exception;

public class LocationServiceException extends RuntimeException{

	
	private static final long serialVersionUID = 8179513994492100553L;

	public LocationServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LocationServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LocationServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LocationServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
