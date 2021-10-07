package com.goldenrace.exception;

public class BadMessageException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public BadMessageException(String message) {
		super(message);
	}
}
