package com.example.flightapi.config;

public class BaseResponse<T> {
	private int code;
	private String message;
	private T data;

	public BaseResponse() {
	}

	public BaseResponse(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static <T> BaseResponse<T> success(T data) {
		return new BaseResponse<>(200, "Success", data);
	}

	public static <T> BaseResponse<T> failure(int code, String message) {
		return new BaseResponse<>(code, message, null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
