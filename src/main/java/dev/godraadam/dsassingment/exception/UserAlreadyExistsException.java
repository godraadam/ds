package dev.godraadam.dsassingment.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("This user is already registered!");
    }
}
