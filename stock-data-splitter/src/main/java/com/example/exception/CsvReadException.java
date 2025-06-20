package com.example.exception;

public class CsvReadException extends Exception{
    public CsvReadException() {

    }

    public CsvReadException(String message) {
        super (message);
    }

    public CsvReadException(Throwable cause) {
        super (cause);
    }

    public CsvReadException(String message, Throwable cause) {
        super (message, cause);
    }
}
