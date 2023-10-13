package com.oosd.ecommerce.exception.CategoryExceptionHandling;

public class CategoryErrorResponse {
    private int status;
    private String message;

    public CategoryErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public CategoryErrorResponse() {}

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
