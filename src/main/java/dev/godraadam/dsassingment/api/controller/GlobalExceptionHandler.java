package dev.godraadam.dsassingment.api.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import dev.godraadam.dsassingment.exception.InvalidCredentialsException;
import dev.godraadam.dsassingment.exception.ResourceNotFoundException;
import dev.godraadam.dsassingment.exception.UserAlreadyExistsException;
import dev.godraadam.dsassingment.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFound() {}

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidCredentialsException.class)
    public void handleIncorrectPassword() {}

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public void handleUsernameTaken() {}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handleResourceNotFound() {}
    
}
