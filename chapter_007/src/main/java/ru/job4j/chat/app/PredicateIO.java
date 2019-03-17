package ru.job4j.chat.app;

import java.io.IOException;

/**
 * Interface PredicateIO
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface PredicateIO<T> {
    boolean test(T t) throws IOException;
}
