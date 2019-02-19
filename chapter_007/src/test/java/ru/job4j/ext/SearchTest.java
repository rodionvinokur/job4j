package ru.job4j.ext;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * SearchTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SearchTest {
    @Test
    public void filesWhenFilterDocxLogThen() throws Exception {
        String[] strings = {
                "2 (1).docx",
                "2 (1).log",
                "2 (2).docx",
                "3 (1).docx",
                "3 (1).log",
                "3 (2).docx",
                "11 (1).docx",
                "11 (1).log",
                "11 (2).docx"
        };

        for (File f : Search.files(System.getProperty("java.io.tmpdir") + File.separator + "My",
                (Arrays.asList("docx", "log")))) {
            System.out.println(f.getCanonicalFile());
            assertTrue(Arrays.stream(strings).anyMatch(f.getName()::equals));
        }
    }

    @Test
    public void filesWhenFilterTxtThen() throws Exception {
        String[] strings = {
                "(1).txt",
                "2 (1).txt",
                "2 (2).txt",
                "2 (3).txt",
                "3 (1).txt",
                "3 (2).txt",
                "3 (3).txt",
                "11 (1).txt",
                "11 (2).txt",
                "11 (3).txt"
        };

        for (File f : Search.files(System.getProperty("java.io.tmpdir") + File.separator + "My",
                (Arrays.asList("txt")))) {
            System.out.println(f.getCanonicalFile());
            assertTrue(Arrays.stream(strings).anyMatch(f.getName()::equals));
        }
    }

    @Test
    public void filesWhenFilterEmptyThen() throws Exception, InterruptedException {
                String[] strings = {};
        for (File f : Search.files(System.getProperty("java.io.tmpdir") + File.separator + "My",
                (Arrays.asList("")))) {
            System.out.println(f.getCanonicalFile());
            assertTrue(Arrays.stream(strings).anyMatch(f.getName()::equals));
        }
    }
}