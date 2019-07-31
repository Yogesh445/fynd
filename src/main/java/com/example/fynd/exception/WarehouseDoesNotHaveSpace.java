package com.example.fynd.exception;

public class WarehouseDoesNotHaveSpace extends Exception {
    public WarehouseDoesNotHaveSpace() {
    }

    public WarehouseDoesNotHaveSpace(String message) {
        super(message);
    }
}
