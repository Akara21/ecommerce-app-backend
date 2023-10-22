package com.oosd.ecommerce.error.CategoryExceptionHandling;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
