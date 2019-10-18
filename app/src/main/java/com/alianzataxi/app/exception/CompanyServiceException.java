package com.alianzataxi.app.exception;

public class CompanyServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CompanyServiceException() {
		super();
	}

	public CompanyServiceException(final String message) {
		super(message);
	}
}