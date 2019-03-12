package ru.job4j.chat;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class Dialog
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Dialog {
    private final Dictionary dictionary;
    private final Journal journal;
    public static final String EXIT = "закончить";
    public static final String AGAIN = "продолжить";
    public static final String STOP = "стоп";

    public Dialog() throws IOException {
        dictionary = new Dictionary(Paths.get("Dictionary", "dictionary.txt"));
        journal = new Journal(Paths.get("Journal", "chat.log"));
    }

    public void init() throws IOException {
        String line;
        IO.writeLine("Bot > Привет!");
        IO.write("Я   > ");
        boolean exit = false;
        boolean stop = false;
        while (!exit) {
            line = IO.readLine();
            switch (line) {
                case EXIT:
                    exit = true;
                    break;
                case AGAIN:
                    stop = false;
                    break;
                case STOP:
                    stop = true;
                    break;
                default:
            }
            journal.writeLine("Я   > " + line);
            if (!exit) {
                if (!stop) {
                    line = "Bot > " + dictionary.readRandomLine();
                    journal.writeLine(line);
                    IO.writeLine(line);
                }
                IO.write("Я   > ");
            }
        }
    }
}
