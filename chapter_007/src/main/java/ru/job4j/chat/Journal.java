package ru.job4j.chat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * Class Journal
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Journal {
    private final Path pathToJournal;

    public Journal(Path pathToJournal) throws IOException {
        this.pathToJournal = pathToJournal;
        if (!Files.exists(pathToJournal)) {
            Files.createFile(pathToJournal);
        } else if (Files.isDirectory(pathToJournal)
                || !Files.isRegularFile(pathToJournal)
                || !Files.isWritable(pathToJournal)) {
            throw new IOException("Invalid journal, check path.");
        }
    }

    public void writeLine(String line) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(pathToJournal,
                StandardCharsets.UTF_8)) {
            bw.write(line);
            bw.newLine();
        } catch (IOException ie) {
            throw new IOException("Check journal");
        }
    }
}

