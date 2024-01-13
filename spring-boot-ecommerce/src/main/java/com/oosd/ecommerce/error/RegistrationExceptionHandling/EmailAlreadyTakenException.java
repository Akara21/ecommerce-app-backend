package com.oosd.ecommerce.error.RegistrationExceptionHandling;

/**
 * This defines the exception for the following error:
 * user with this email already exists.
 */
public class EmailAlreadyTakenException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public EmailAlreadyTakenException(String message) {
        super(message);
    }
}