package ru.job4j.finder.find;

import ru.job4j.finder.opt.OptionDirectory;
import ru.job4j.finder.opt.OptionJournal;
import ru.job4j.finder.opt.OptionName;
import ru.job4j.finder.opt.Rule;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Class App
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

public class App {
    public static void main(String[] args) {
        new App().init(createOptionString(args));
    }

    public void init(String option) {
        Map<Class, Supplier<?>> map = new HashMap<>();
        map.put(Path.class, new OptionDirectory(option)::apply);
        map.put(Rule.class, new OptionName(option)::apply);
        map.put(PrintWriter.class, new OptionJournal(option)::apply);
        PrintWriter out = PrintWriter.class.cast(map.get(PrintWriter.class).get());
        try {
            Files.walkFileTree(Path.class.cast(map.get(Path.class).get()),
                    new FindFileVisitor(Rule.class.cast(map.get(Rule.class).get()), out));
        } catch (IOException e) {
            System.out.println("Check file system.");
        } catch (Exception e) {
            System.out.println("Something go wrong...");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static String createOptionString(String[] strings) {
        return Arrays.stream(strings).collect(Collectors.joining(" "));
    }
}
