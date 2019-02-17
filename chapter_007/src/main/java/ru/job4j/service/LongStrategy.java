package ru.job4j.service;

import java.io.*;

/**
 * LongStrategy
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class LongStrategy implements CheckStrategy {
    @Override
    public boolean check(InputStream in) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(in));
        try {
            while (true) {
                long number = dataInputStream.readLong();
                if (number % 2 == 0) {
                    return true;
                }
            }
        } catch (EOFException eof) {
            return false;
        }
    }
}
