package com.example.exception;

public class CsvWriteException extends Exception{
    public CsvWriteException() {

    }

    public CsvWriteException(String message) {
        super(message);
    }

    public CsvWriteException(Throwable cause) {
        super(cause);
    }

    public CsvWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
