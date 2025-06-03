package com.example.flightapi.exception;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.flightapi.config.BaseResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	// 处理所有自定义异常
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<BaseResponse<Object>> handleCustomException(CustomException ex) {
		String message = messageSource.getMessage(ex.getMessage(), null, ex.getMessage(), Locale.ENGLISH);
		return new ResponseEntity<>(BaseResponse.failure(ex.getCode(), message), HttpStatus.BAD_REQUEST);
	}

	// 处理参数校验失败异常
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BaseResponse<Object>> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		String message = messageSource.getMessage("error.validation", null, Locale.ENGLISH);
		return new ResponseEntity<>(BaseResponse.failure(400, message + errors.toString()), HttpStatus.BAD_REQUEST);
	}

	// 捕获其他未处理的异常
	@ExceptionHandler(Exception.class)
	public ResponseEntity<BaseResponse<Object>> handleException(Exception ex) {
		String message = messageSource.getMessage("error.internal", null, Locale.ENGLISH);
		return new ResponseEntity<>(BaseResponse.failure(500, message + ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
