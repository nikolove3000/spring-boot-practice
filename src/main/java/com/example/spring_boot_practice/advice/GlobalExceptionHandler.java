package com.example.spring_boot_practice.advice;

import com.example.spring_boot_practice.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for REST controllers.
 * <p>
 * Captures validation-related exceptions and returns
 * standardized error responses to the client.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation errors triggered by @Valid annotation
     * when request body validation fails.
     *
     * @param ex the MethodArgumentNotValidException containing validation details
     * @return ResponseEntity containing an ErrorResponse with HTTP 400 status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(400, message));
    }
}