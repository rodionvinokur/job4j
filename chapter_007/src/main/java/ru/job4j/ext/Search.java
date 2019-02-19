package ru.job4j.ext;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Search
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Search {

    public static List<File> files(String parent, List<String> exts) {
        Objects.requireNonNull(parent);
        File dir = new File(parent);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Wrong path!");
        }
        List<File> fileList = new ArrayList<>();
        Queue<File> queue = new ArrayDeque<>();
        queue.add(dir);
        do {
            for (File f : queue.poll().listFiles()) {
                if (f.isDirectory()) {
                    queue.add(f);
                }
                if (f.isFile()
                        && exts.contains(f.getName()
                        .substring(f.getName().lastIndexOf(".") + 1))
                        ) {
                    fileList.add(f);
                }
            }
        } while (!queue.isEmpty());
        return fileList;
    }
}
