package com.oosd.ecommerce.error.ProductExceptionHandling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * This provides the functionality for building a response to product exceptions.
 */
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductErrorResponse {
    private int status;
    private String message;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
