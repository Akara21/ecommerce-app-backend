package com.oosd.ecommerce.error.ProductExceptionHandling;

public class ProductErrorResponse {
    private int status;
    private String message;

    public ProductErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ProductErrorResponse() {}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
