package com.ecoandrich.support.exception;

public class WrongRateRangeException extends RuntimeException {
    public WrongRateRangeException(String message) {
        super(message);
    }

    public WrongRateRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
