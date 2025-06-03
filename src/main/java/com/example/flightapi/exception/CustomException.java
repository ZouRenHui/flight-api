package com.example.flightapi.exception;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final int code;

	public CustomException(int code, String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
