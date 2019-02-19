package ru.job4j.abuse;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * FilterOfWordsTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FilterOfWordsTest {

    @Test
    public void whenTwoLinesThen() throws IOException {
        testIO("aba baba aa b ccc"
                + System.lineSeparator() + "afa aa laba aab ddd", "aba baba ccc"
                + System.lineSeparator() + "afa laba aab ddd", new String[]{"aa", "b"});
    }

    @Test
    public void whenOneLinesThen() throws IOException {
        testIO("aba baba aa b ccc", "aba baba ccc", new String[]{"aa", "b"});
    }

    @Test
    public void whenEmptyOneLinesThen() throws IOException {
        testIO("", "", new String[]{"aa", "b"});
    }

    private void testIO(String strIn, String expected, String[] abuse) throws IOException {
        try (InputStream is = new ByteArrayInputStream((strIn).getBytes());
             ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            FilterOfWords.dropAbuses(is, baos, abuse);
            System.out.println(Arrays.toString(baos.toByteArray()));
            System.out.println(Arrays.toString(expected.getBytes()));
            assertArrayEquals(expected.getBytes(), baos.toByteArray());
        }
    }
}