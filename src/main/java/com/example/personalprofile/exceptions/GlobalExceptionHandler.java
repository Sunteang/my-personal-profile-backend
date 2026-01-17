package com.example.personalprofile.exceptions;

import com.example.personalprofile.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle resource not found (404)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiResponse<Void> response = new ApiResponse<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle bad request errors (400)
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(Exception ex) {
        ApiResponse<Void> response = new ApiResponse<>(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    // Optional: other specific exceptions...
}

