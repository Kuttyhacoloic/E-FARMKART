package com.efarmkart.app.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.efarmkart.app.response.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<String> > handleResouceNotFound(ResourceNotFoundException ex)
	{
		return ResponseEntity.status(404).body( new ApiResponse<>("Resource Not Found", ex.getMessage(), false));
	}

}
     	