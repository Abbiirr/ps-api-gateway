package com.example.api_gateway.enums;

public enum EventStatus {
    CREATED("CREATED"),
    PENDING("PENDING"),
    COMPLETED("COMPLETED"),
    FAILED("FAILED");

    private final String status;

    EventStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
