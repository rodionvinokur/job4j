package ru.job4j.chat.app;

import java.io.IOException;

/**
 * Interface ConsumerIO
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface ConsumerIO<T> {
    void accept(T t) throws IOException;
}
