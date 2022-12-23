package com.sdk.threatwinds.enums;

public enum TWConstants {
    // Prefix of the threat winds endpoints API
    API_PREFIX("api");

    private String constant;

    TWConstants(String constant) {
        this.constant = constant;
    }

    public String get() {
        return constant;
    }
}
