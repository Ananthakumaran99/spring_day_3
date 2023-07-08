package com.jsp.springday3.exception;

public class NameNotFoundException extends RuntimeException{
	private String message;

	public NameNotFoundException(String message) {
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
