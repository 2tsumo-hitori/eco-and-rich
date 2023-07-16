package com.ecoandrich.support.exception;

public class WrongParameterNameException extends RuntimeException {
    public WrongParameterNameException(String message) {
        super(message);
    }

    public WrongParameterNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
