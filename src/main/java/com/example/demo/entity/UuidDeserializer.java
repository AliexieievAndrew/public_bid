package com.example.demo.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.UUID;

public class UuidDeserializer extends JsonDeserializer<UUID> {

    private final static String REGEX_UUID =
            "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)";

    private final static String REPLACEMENT_UUID = "$1-$2-$3-$4-$5";

    @Override
    public UUID deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return UUID.fromString(jsonParser.getValueAsString()
                .replaceFirst(REGEX_UUID, REPLACEMENT_UUID));
    }
}
