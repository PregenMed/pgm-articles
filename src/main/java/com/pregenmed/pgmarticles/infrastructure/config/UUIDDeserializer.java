package com.pregenmed.pgmarticles.infrastructure.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UUIDDeserializer extends JsonDeserializer<UUID> {

    // TODO move to  props or somewhere else
    String UUID_V7_REGEX_STRING = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-7[0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";

    @Override
    public UUID deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        Pattern compiledPattern = Pattern.compile(UUID_V7_REGEX_STRING);

        String uuidString = p.getText();
        Matcher matcher = compiledPattern.matcher(p.getText());

        if (matcher.matches()) {
            try {
                return UUID.fromString(uuidString);
            } catch (IllegalArgumentException e) {
                throw new IOException("Invalid UUID format: " + uuidString); // TODO add custom exception
            }
        } else {
            throw new IOException("Invalid UUID format: " + uuidString);
        }

    }
}
