package ru.job4j.chat.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Class IO
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class IO {
    public static String readLine() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            return br.readLine().toLowerCase();
        } catch (IOException ie) {
            throw new IOException("Good bye in");
        }
    }

    public static void writeLine(String line) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
            bw.write(line);
            bw.newLine();
            bw.flush();
        } catch (IOException ie) {
            ie.printStackTrace();
            throw new IOException();
        }
    }

    public static void write(String line) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
            bw.write(line);
            bw.flush();
        } catch (IOException ie) {
            ie.printStackTrace();
            throw new IOException();
        }
    }
}
