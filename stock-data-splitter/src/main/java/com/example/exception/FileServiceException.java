package com.example.exception;

public class FileServiceException extends Exception{
    public FileServiceException() {

    }

    public FileServiceException(String message) {
        super (message);
    }

    public FileServiceException(Throwable cause) {
        super (cause);
    }

    public FileServiceException(String message, Throwable cause) {
        super (message, cause);
    }    
}
