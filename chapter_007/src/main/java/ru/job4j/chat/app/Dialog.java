package ru.job4j.chat.app;

import ru.job4j.chat.util.IO;
import ru.job4j.chat.dict.Dictionary;
import ru.job4j.chat.dict.IDict;
import ru.job4j.chat.log.ILog;
import ru.job4j.chat.log.Journal;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Dialog
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Dialog {
    public static final String EXIT = "закончить";
    public static final String AGAIN = "продолжить";
    public static final String STOP = "стоп";
    public static final String START = "start bot dialog";
    private final IDict dictionary;
    private final ILog journal;
    private final ConsumerIO<String> log;
    private final PredicateIO<String> onAgain;
    private final PredicateIO<String> onStop;
    private final PredicateIO<String> onStart;
    private final PredicateIO<String> onExit;

    private final Map<String, PredicateIO<String>> doActionByAnswer = new HashMap<>();
    private final Map<PredicateIO<String>, PredicateIO<String>> getDefault = new HashMap<>();

    public Dialog() throws IOException {
        dictionary = new Dictionary(Paths.get("Dictionary", "dictionary.txt"));
        journal = new Journal(Paths.get("Journal", "chat.log"));
        log = journal::writeLine;
        onExit = (line) -> {
            log.accept("Я   > " + line);
            return false;
        };
        onAgain = (line) -> {
            log.accept("Я   > " + line);
            line = "Bot > " + dictionary.readRandomLine();
            log.accept(line);
            IO.writeLine(line);
            IO.write("Я   > ");
            return true;
        };
        onStop = (line) -> {
            log.accept("Я   > " + line);
            IO.write("Я   > ");
            return true;
        };

        onStart = (line) -> {
            IO.writeLine("Bot > Привет!");
            log.accept("Bot > Привет!");
            IO.write("Я   > ");
            return true;
        };
    }


    public void init() throws IOException {
        String line = null;
        buildMapAnswers();
        PredicateIO<String> func = doActionByAnswer.getOrDefault(line, onStart);
        PredicateIO<String> def = onAgain;
        while (func.test(line)) {
            line = IO.readLine();
            func = doActionByAnswer.getOrDefault(line, def);
            def = getDefault.getOrDefault(func, def);
        }
    }

    private void buildMapAnswers() throws IOException {
        doActionByAnswer.put(EXIT, onExit);
        doActionByAnswer.put(AGAIN, onAgain);
        doActionByAnswer.put(STOP, onStop);
        doActionByAnswer.put(START, onStart);
        getDefault.put(onStop, onStop);
        getDefault.put(onAgain, onAgain);
    }
}
