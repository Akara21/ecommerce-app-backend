package com.oosd.ecommerce.error.CategoryExceptionHandling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * This provides the functionality for building a response to category exceptions.
 */
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class CategoryErrorResponse {
    private int status;
    private String message;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
