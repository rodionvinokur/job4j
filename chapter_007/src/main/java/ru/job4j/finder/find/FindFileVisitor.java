package ru.job4j.finder.find;

import ru.job4j.finder.opt.Rule;

import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * Class App
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

public class FindFileVisitor extends SimpleFileVisitor<Path> {
    private final Rule rule;
    private final PrintWriter out;

    public FindFileVisitor(Rule rule, PrintWriter out) {
        this.rule = rule;
        this.out = out;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (rule.check(file.getFileName().toString())) {
            out.println(file.toString());
        }
        return FileVisitResult.CONTINUE;
    }
}
