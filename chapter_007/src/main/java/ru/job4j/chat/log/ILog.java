package ru.job4j.chat.log;

import java.io.IOException;

/**
 * Interface ILog
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface ILog {
    void writeLine(String line) throws IOException;
}
