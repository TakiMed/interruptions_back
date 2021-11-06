package com.example.predavanjademo.exceptions;

import org.springframework.validation.Errors;

public class ValidationException extends Exception {
    private String message;
    private Errors errors;

    public ValidationException(String message, Errors errors) {
        super(message);
        this.message = message;
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Errors getErrors() {
        return errors;
    }
}
