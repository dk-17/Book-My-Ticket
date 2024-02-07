package com.bookMyTicket.exception;

public class CityAlreadyExistsException extends RuntimeException{
    public CityAlreadyExistsException(String message) {
        super(message);
    }
}
