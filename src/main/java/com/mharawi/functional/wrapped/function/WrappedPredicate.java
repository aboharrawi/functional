package com.mharawi.functional.wrapped.function;

import java.util.Objects;

@FunctionalInterface
public interface WrappedPredicate<T> {
    boolean test(T t) throws Exception;

    default WrappedPredicate<T> and(WrappedPredicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    default WrappedPredicate<T> negate() {
        return (t) -> !test(t);
    }

    default WrappedPredicate<T> or(WrappedPredicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> WrappedPredicate<T> isEqual(Object targetRef) {
        return null == targetRef ? Objects::isNull : targetRef::equals;
    }
}
