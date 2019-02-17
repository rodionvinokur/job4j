package ru.job4j.service;

import java.io.*;

/**
 * ByteStrategy
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ByteStrategy implements CheckStrategy {

    @Override
    public boolean check(InputStream in) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(in));
        try {
            while (true) {
                int number = dataInputStream.readByte();
                if (number % 2 == 0) {
                    return true;
                }
            }
        } catch (EOFException eof) {
            return false;
        }
    }
}
