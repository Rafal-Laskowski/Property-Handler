package io.github.rafal.laskowski.properties;

import java.util.Optional;
import java.util.function.Supplier;

class PropertyFactory {
    private static final String EXCEPTION_MESSAGE = "Property [%s] is null. Use `getNullable[Type](String propertyName)` to retrieve properties with nulls";

    public static <T> Optional<T> getNullable(Property<T> property, Class<T> clazz) {
        return property.getOptional(clazz);
    }

    public static <T> T get(Property<T> property, Class<T> clazz) {
        return getNullable(property, clazz).orElseThrow(getSupplier(property));
    }

    private static <T> Supplier<? extends IllegalArgumentException> getSupplier(Property<T> property) {
        return () -> getException(property.getKey());
    }

    private static IllegalArgumentException getException(String propertyKey) {
        return new IllegalArgumentException(String.format(EXCEPTION_MESSAGE, propertyKey));
    }
}
