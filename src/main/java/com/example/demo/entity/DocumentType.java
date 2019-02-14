package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
    SUB_CONTRACT("subContract"),
    CONTRACT_ANNEXE("contractAnnexe"),
    CONTRACT_SIGNED("contractSigned"),
    UNKNOWN("unknown");

    @JsonValue
    private String value;

    DocumentType(String value) {
        this.value = value;
    }

    @JsonCreator
    DocumentType fromString(String value) {
        for (DocumentType documentType:values()) {
            if(documentType.value.equalsIgnoreCase(value))
                return documentType;
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return value;
    }
}
