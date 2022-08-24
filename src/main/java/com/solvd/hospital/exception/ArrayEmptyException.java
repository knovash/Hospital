package com.solvd.hospital.exception;

public class ArrayEmptyException extends RuntimeException {

    public ArrayEmptyException(String message) {
        super(message);
    }

    public ArrayEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
