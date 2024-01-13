package com.oosd.ecommerce.error.CategoryExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This provides the functionality for exception handling for category API-endpoints.
 */
@ControllerAdvice
public class CategoryExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CategoryErrorResponse> handleException(CategoryNotFoundException exc) {
        CategoryErrorResponse error = new CategoryErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CategoryErrorResponse> handleException(Exception exc) {
        CategoryErrorResponse error = new CategoryErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
