package com.mharawi.functional.wrapped.function;

import java.util.Objects;

@FunctionalInterface
public interface WrappedConsumer<T> {
    void accept(T t) throws Exception;

    default WrappedConsumer<T> andThen(WrappedConsumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }
}
