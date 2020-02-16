package com.mharawi.functional.wrapped.function;

@FunctionalInterface
public interface WrappedSupplier<T> {
    T get() throws Exception;
}

