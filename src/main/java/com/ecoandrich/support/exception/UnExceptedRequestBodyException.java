package com.ecoandrich.support.exception;

public class UnExceptedRequestBodyException extends IllegalArgumentException {
    public UnExceptedRequestBodyException(String s) {
        super(s);
    }

    public UnExceptedRequestBodyException(String message, Throwable cause) {
        super(message, cause);
    }
}
