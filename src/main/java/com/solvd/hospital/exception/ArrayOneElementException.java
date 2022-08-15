package com.solvd.hospital.exception;

public class ArrayOneElementException extends Exception {

    public ArrayOneElementException(String message) {
        super(message);
    }

    public ArrayOneElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
