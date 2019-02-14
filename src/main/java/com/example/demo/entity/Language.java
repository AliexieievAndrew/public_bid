package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Language {
    UK("uk"),
    UNKNOWN("unknown");

    @JsonValue
    private String value;

    Language(String value) {
        this.value = value;
    }

    Language fromString (String value) {
        for (Language language:values()) {
            if(language.value.equalsIgnoreCase(value))
                return language;
        }
        return UNKNOWN;
    }
    @Override
    public String toString() {
        return value;
    }
}
