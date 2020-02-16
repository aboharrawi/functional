package com.mharawi.functional.wrapped;

import com.mharawi.functional.wrapped.function.*;

import java.util.function.*;

public class Wrapper {

    private Wrapper() {
    }

    public static <A1, R> Function<A1, R> wrapFunction(WrappedFunction<A1, R> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <A1> Consumer<A1> wrapConsumer(WrappedConsumer<A1> consumer) {
        return s -> {
            try {
                consumer.accept(s);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <A1> Predicate<A1> wrapPredicate(WrappedPredicate<A1> predicate) {
        return s -> {
            try {
                return predicate.test(s);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <A1> Supplier<A1> wrapSupplier(WrappedSupplier<A1> supplier) {
        return () -> {
            try {
                return supplier.get();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <A1, A2> BiConsumer<A1, A2> wrapBiConsumer(WrappedBiConsumer<A1, A2> biConsumer) {
        return (t, u) -> {
            try {
                biConsumer.accept(t, u);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <A1, A2, R> BiFunction<A1, A2, R> wrapBiFunction(WrappedBiFunction<A1, A2, R> biFunction) {
        return (t, u) -> {
            try {
                return biFunction.apply(t, u);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
