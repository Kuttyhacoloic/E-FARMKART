package com.efarmkart.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
	
    private String message;
    private T data;
    private boolean success;
}
