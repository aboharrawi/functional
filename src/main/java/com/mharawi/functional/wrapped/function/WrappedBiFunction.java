package com.mharawi.functional.wrapped.function;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface WrappedBiFunction<T, U, R> {
    R apply(T t, U u) throws Exception;

    default <V> WrappedBiFunction<T, U, V> andThen(WrappedFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }
}
