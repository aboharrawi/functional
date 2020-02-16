package com.mharawi.functional.wrapped.function;

import java.util.Objects;

@FunctionalInterface
public interface WrappedFunction<T, R> {
    R apply(T t) throws Exception;

    default <V> WrappedFunction<V, R> compose(WrappedFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> WrappedFunction<T, V> andThen(WrappedFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> WrappedFunction<T, T> identity() {
        return t -> t;
    }
}
