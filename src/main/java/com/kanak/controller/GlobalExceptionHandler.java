package com.kanak.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.kanak.exception.OrderNotFoundException;
import com.kanak.exception.ProductNotFoundException;
import com.kanak.helper.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ProductNotFoundException.class)
	public ResponseEntity<?> handleProductNotFound(ProductNotFoundException exception,WebRequest request){
		ErrorResponseDto err = new ErrorResponseDto(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				"Not Found", 
				exception.getMessage(), 
				request.getDescription(false).replace("uri=", ""));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = OrderNotFoundException.class)
	public ResponseEntity<?> handleOrderNotFound(OrderNotFoundException exception,WebRequest request){
		ErrorResponseDto err = new ErrorResponseDto(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				"Not Found", 
				exception.getMessage(), 
				request.getDescription(false).replace("uri=", ""));
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
}
