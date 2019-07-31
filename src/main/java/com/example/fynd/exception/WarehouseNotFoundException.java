package com.example.fynd.exception;

public class WarehouseNotFoundException extends Exception {
    public WarehouseNotFoundException() {
    }

    public WarehouseNotFoundException(String message) {
        super(message);
    }
}
