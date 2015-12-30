package com.edu.fatecbt.sistema.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public abstract class ValidatedEntity {

    private Map<String, String> errorMessages = new HashMap<>();

    public void addErrorMessage(String key, String value) {
        errorMessages.put(key, value);
    }

    public void removeErrorMessage(String key) {
        errorMessages.remove(key);
    }

    public String getErrorMessageBy(String key) {
        return errorMessages.get(key);
    }

    public boolean notEmptyString(String... values) {
        boolean hasFailures = Stream.of(values)
                .map(v -> v != null && !v.isEmpty())
                .filter(b -> b.equals(Boolean.FALSE))
                .findAny()
                .isPresent();
        return !hasFailures;
    }

    public abstract boolean isValid();

}
