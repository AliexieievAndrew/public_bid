package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
 * Examples
 * https://stackoverflow.com/questions/31689107/deserializing-an-enum-with-jackson
 */

public enum DocumentOf {
    TENDER("tender"),
    CONTRACT("contract"),
    CHANGE("change"),
    UNKNOWN("unknown");

    @JsonValue
    private String value;

    DocumentOf(String value) {
        this.value = value;
    }

    @JsonCreator
    DocumentOf fromString(String value) {
        for (DocumentOf documentOf:values()) {
            if (documentOf.value.equalsIgnoreCase(value))
                return documentOf;
        }
        return UNKNOWN;
    }
    @Override
    public String toString() {
        return value;
    }
}
