package com.oosd.ecommerce.error.CategoryExceptionHandling;

/**
 * This defines the exception for the following error:
 * Category not found.
 */
public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
