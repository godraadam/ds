package dev.godraadam.dsassingment.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("No such user found!");
    }
}
