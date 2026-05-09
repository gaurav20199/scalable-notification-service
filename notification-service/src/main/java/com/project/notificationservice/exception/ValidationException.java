package com.project.notificationservice.exception;

public class ValidationException extends RuntimeException implements BaseException {

    private int statusCode;

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return getMessage();
    }
}
