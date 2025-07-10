package org.s017.accountservice.exception;

public class EmailAlreadyInUseException extends RuntimeException{

    public EmailAlreadyInUseException() {
        super("Email already in use");
    }
}
