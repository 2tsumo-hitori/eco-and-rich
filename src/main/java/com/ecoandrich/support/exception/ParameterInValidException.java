package com.ecoandrich.support.exception;

public class ParameterInValidException extends RuntimeException {
    public ParameterInValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterInValidException(String message) {
        super(message);
    }
}
