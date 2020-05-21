package io.github.rafal.laskowski.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class Properties {
    private static volatile java.util.Properties properties = new java.util.Properties();

    public static synchronized void loadFile(File file) throws IOException {
        Objects.requireNonNull(file);
        if (file.exists() && file.isFile()) {
            properties.load(new FileInputStream(file));
        } else {
            throw new IllegalArgumentException("Provided file doesn't exist or is not a file!");
        }
    }

    public static synchronized String getString(String propertyName) {
        return get(propertyName);
    }

    public static synchronized Boolean getBoolean(String propertyName) {
        return get(propertyName);
    }

    public static synchronized Long getLong(String propertyName) {
        return get(propertyName);
    }

    public static synchronized Integer getInteger(String propertyName) {
        return get(propertyName);
    }

    public static synchronized Double getDouble(String propertyName) {
        return get(propertyName);
    }

    public static synchronized Float getFloat(String propertyName) {
        return get(propertyName);
    }

    public static synchronized Optional<String> getNullableString(String propertyName) {
        return getNullable(propertyName);
    }

    public static synchronized Optional<Boolean> getNullableBoolean(String propertyName) {
        return getNullable(propertyName);
    }

    public static synchronized Optional<Long> getNullableLong(String propertyName) {
        return getNullable(propertyName);
    }

    public static synchronized Optional<Integer> getNullableInteger(String propertyName) {
        return getNullable(propertyName);
    }

    public static synchronized Optional<Double> getNullableDouble(String propertyName) {
        return getNullable(propertyName);
    }

    public static synchronized Optional<Float> getNullableFloat(String propertyName) {
        return getNullable(propertyName);
    }

    private static synchronized <T> Optional<T> getNullable(String propertyName) {
        return PropertyFactory.getNullable(getProperty(propertyName));
    }

    private static synchronized <T> T get(String propertyName) {
        return PropertyFactory.get(getProperty(propertyName));
    }

    private static synchronized <T> Property<T> getProperty(String propertyName) {
        return new Property<>(properties.getProperty(propertyName));
    }
}
