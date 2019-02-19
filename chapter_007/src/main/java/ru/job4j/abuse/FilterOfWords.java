package ru.job4j.abuse;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * FilterOfWords
 * Класс декоратор.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FilterOfWords extends BufferedReader {
    private final BufferedReader in;
    private final String[] abuse;
    private StringBuilder bufferToRead = new StringBuilder();
    private boolean start = true;

    private FilterOfWords(BufferedReader in, String[] abuse) {
        super(in);
        this.in = in;
        this.abuse = abuse;
    }

    public static void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        FilterOfWords fow = new FilterOfWords(new BufferedReader(new InputStreamReader(in)), abuse);
        OutputStreamWriter osw = new OutputStreamWriter(out);
        int readByte = -1;
        while ((readByte = fow.read()) != -1) {
            osw.write(readByte);
            osw.flush();
        }
    }

    @Override
    public int read() throws IOException {
        if (bufferToRead.length() != 0) {
            return getFromBuffer();
        }
        String s = in.readLine();
        if (s == null) {
            return -1;
        }
        if (!start) {
            bufferToRead.append(System.lineSeparator());
        } else {
            start = false;
        }
        bufferToRead
                .append(Arrays.stream(s.split(" ")).filter(this::notIn).collect(Collectors.joining(" ")));

        return getFromBuffer();
    }

    private int getFromBuffer() {
        int rc = bufferToRead.charAt(0);
        bufferToRead.deleteCharAt(0);
        return rc;
    }

    private boolean notIn(String s) {
        return !Arrays.stream(abuse).anyMatch(s::equals);
    }
}
