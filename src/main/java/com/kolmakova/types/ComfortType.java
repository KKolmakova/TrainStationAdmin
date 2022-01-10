package com.kolmakova.types;

public enum ComfortType {

    RESERVED_SEAT("Reserved seat"),
    COMPARTMENT("Compartment");

    private String displayType;

    ComfortType(String displayType) {
        this.displayType = displayType;
    }

    public String displayName() {
        return displayType;
    }

    @Override
    public String toString() {
        return displayType;
    }
}
