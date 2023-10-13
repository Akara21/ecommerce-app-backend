package com.oosd.ecommerce.exception.ProductExceptionHandling;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
