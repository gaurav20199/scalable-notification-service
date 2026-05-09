package com.project.notificationservice.exception;

public class ResourceNotFoundException extends RuntimeException implements BaseException {
    private int statusCode;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String getErrorMessage() {
        return getMessage();
    }
}
