package io.github.rafal.laskowski.properties;

import java.util.Optional;

class Property<T> {
    private String value;

    public Property(String value) {
        this.value = value;
    }

    public boolean isNullOrEmpty() {
        return value != null && !value.equalsIgnoreCase("null") && !value.isEmpty();
    }

    @SuppressWarnings(value = "unchecked")
    public T getValue() {
        return (T) value;
    }

    public Optional<T> getOptional() {
        if (isNullOrEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(getValue());
        }
    }
}
