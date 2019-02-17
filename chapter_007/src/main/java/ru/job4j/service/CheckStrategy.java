package ru.job4j.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * CheckStrategy
 *
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface CheckStrategy {
    public boolean check(InputStream in)  throws IOException;
}
