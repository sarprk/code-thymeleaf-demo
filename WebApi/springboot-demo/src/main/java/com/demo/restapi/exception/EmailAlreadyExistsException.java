package com.demo.restapi.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    private String message;

    public EmailAlreadyExistsException(String message)
    {
        super(message);
        this.message = message;
    }
}
