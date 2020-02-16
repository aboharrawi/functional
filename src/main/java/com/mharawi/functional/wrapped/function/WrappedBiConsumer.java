package com.mharawi.functional.wrapped.function;

import java.util.Objects;

@FunctionalInterface
public interface WrappedBiConsumer<T, U> {

    void accept(T t, U u) throws Exception;

    default WrappedBiConsumer<T, U> andThen(WrappedBiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after);
        return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };
    }
}
