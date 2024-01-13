package com.oosd.ecommerce.error.ProductExceptionHandling;

/**
 * This defines the exception for the following error:
 * Product not found.
 */
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
