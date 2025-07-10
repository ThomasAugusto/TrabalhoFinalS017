package org.s017.borrowingservice.exception;

public class BorrowNotFoundException extends RuntimeException{
    public BorrowNotFoundException() {
        super("Borrow not found");
    }
}
