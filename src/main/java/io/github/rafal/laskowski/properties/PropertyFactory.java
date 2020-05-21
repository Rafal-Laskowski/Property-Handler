package io.github.rafal.laskowski.properties;

import java.util.Optional;
import java.util.function.Supplier;

public class PropertyFactory {
    private static final String EXCEPTION_MESSAGE = "Property [%s] is null. Use `getNullable[Type](String propertyName)` to retrieve properties with nulls";

    public static <T> Optional<T> getNullable(Property<T> property) {
        return property.getOptional();
    }

    public static <T> T get(Property<T> property) {
        return getNullable(property).orElseThrow(getSupplier(property));
    }

    private static <T> Supplier<? extends IllegalArgumentException> getSupplier(Property<T> property) {
        return () -> getException(property.getValue());
    }

    private static IllegalArgumentException getException(Object propertyName) {
        return new IllegalArgumentException(String.format(EXCEPTION_MESSAGE, propertyName.toString()));
    }
}
