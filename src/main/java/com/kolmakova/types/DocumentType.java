package com.kolmakova.types;

public enum DocumentType {

    PASSPORT("passport"),
    RESIDENT_CARD("resident card"),
    CERTIFICATE("certificate");

    private String displayType;

    DocumentType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayName() {
        return displayType;
    }

}

