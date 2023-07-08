package com.jsp.springday3.exception;

public class IdNotFoundException extends RuntimeException {
	private String message;

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
