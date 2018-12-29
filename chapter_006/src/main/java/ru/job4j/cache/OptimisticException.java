package ru.job4j.cache;

/**
 * Created by slevi on 27.12.2018.
 */
public class OptimisticException extends RuntimeException {
    public OptimisticException(String m) {
        super(m);
    }
}
