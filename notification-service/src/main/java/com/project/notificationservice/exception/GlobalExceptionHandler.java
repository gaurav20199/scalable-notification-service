package com.project.notificationservice.exception;

import com.project.notificationservice.utils.NotificationServiceUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.function.Supplier;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleBadRequestException(ValidationException e) {
        return handleAnyException(e,() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return handleAnyException(e,() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()));
    }

    public ResponseEntity<String> handleAnyException(final BaseException handler, final Supplier<ResponseEntity<String>> supplier) {
        if(NotificationServiceUtil.isObjectNotEmpty(handler.getStatusCode())) {
            return ResponseEntity.status(handler.getStatusCode()).body(handler.getErrorMessage());
        }
        return supplier.get();
    }
}
