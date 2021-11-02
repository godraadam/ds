package dev.godraadam.dsassingment.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("The provided credentials do not match!");
    }
}
