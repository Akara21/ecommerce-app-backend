package com.oosd.ecommerce.exception.CategoryExceptionHandling;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
