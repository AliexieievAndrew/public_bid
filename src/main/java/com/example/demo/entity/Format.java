package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Format {
    APPLICATION_PKCS_SIGNATURE("application/pkcs7-signature"),
    TEXT_PLAIN("text/plain"),
    IMAGE_JPEG("image/jpeg"),
    APPLICATION_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    APPLICATION_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    IMAGE_PNG("image/png"),
    UNKNOWN("unknown");

    @JsonValue
    String value;

    Format(String value) {
        this.value = value;
    }

    @JsonCreator
    Format fromString(String value){
        for (Format format:values()) {
            if(format.value.equalsIgnoreCase(value))
                return format;
        }
        return UNKNOWN;
    }
    @Override
    public String toString() {
        return value;
    }
}

