package com.oosd.ecommerce.error.ProductExceptionHandling;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
