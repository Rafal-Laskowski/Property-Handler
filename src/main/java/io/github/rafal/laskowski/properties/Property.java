package io.github.rafal.laskowski.properties;

import java.util.Optional;

class Property<T> {
    private String key;
    private String value;

    public Property(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean isNullOrEmpty() {
        if (value != null) {
            return value.equalsIgnoreCase("null") || value.isEmpty();
        } else return true;
    }

    public String getKey() {
        return key;
    }

    @SuppressWarnings("unchecked")
    public T getValue(Class<T> clazz) {
        Object properType = null;
        if (clazz.isAssignableFrom(String.class)) {
            properType = value;
        } else if (clazz.isAssignableFrom(Boolean.class)) {
            properType = Boolean.parseBoolean(value);
        } else if (clazz.isAssignableFrom(Double.class)) {
            properType = Double.parseDouble(value);
        } else if (clazz.isAssignableFrom(Float.class)) {
            properType = Float.parseFloat(value);
        } else if (clazz.isAssignableFrom(Long.class)) {
            properType = Long.parseLong(value);
        } else if (clazz.isAssignableFrom(Integer.class)) {
            properType = Integer.parseInt(value);
        } else {
            throw new IllegalArgumentException(String.format("Unknown type: [%s]", clazz.getSimpleName()));
        }

        return (T) properType;
    }

    public Optional<T> getOptional(Class<T> clazz) {
        if (isNullOrEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(getValue(clazz));
        }
    }
}
