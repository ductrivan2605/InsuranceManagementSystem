package com.insurancemanagementsystem.exception;

public class ClaimNotFoundException extends RuntimeException {

    public ClaimNotFoundException(String message) {
        super(message);
    }
}