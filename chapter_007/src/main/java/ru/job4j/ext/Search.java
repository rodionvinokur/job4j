package ru.job4j.ext;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Search
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Search {
    private final Queue<File> queueAllDirectory = new ConcurrentLinkedQueue<>();
    private final Queue<File> queue = new ArrayDeque<>();
    private final String parent;
    private final List<String> exts;
    private volatile boolean stop = false;
    private final List<File> fileList = new ArrayList<>();

    public Search(String parent, List<String> exts) {
        this.parent = parent;
        this.exts = exts;
    }

    private void getDirectory() {
        Objects.requireNonNull(parent);
        File dir = new File(parent);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Wrong path!");
        }
        addToQueue(dir);
        do {
            for (File f : queue.poll().listFiles()) {
                if (f.isDirectory()) {
                    addToQueue(f);
                }
            }
        } while (!queue.isEmpty());
        stop = true;
    }

    private void addToQueue(File f) {
        queue.add(f);
        queueAllDirectory.add(f);
    }

    private void getFileList() {
        while (!(queueAllDirectory.isEmpty() && stop)) {
            if (queueAllDirectory.isEmpty()) {
                Thread.yield();
            }
            File f = queueAllDirectory.poll();
            fileList.addAll(Arrays.stream(f.listFiles()).parallel().filter(File::isFile)
                    .filter(x -> exts.contains(x.getName()
                            .substring(x.getName().lastIndexOf(".") + 1)))
                    .collect(Collectors.toList()));
        }
    }

    public static List<File> files(String parent, List<String> exts) throws InterruptedException {
        int countProcessors = Runtime.getRuntime().availableProcessors();
        Search search = new Search(parent, exts);
        ExecutorService executor = Executors.newFixedThreadPool(countProcessors);
        Runnable dirsSearch = search::getDirectory;
        Runnable filesSearch = search::getFileList;
        executor.submit(dirsSearch);
        Future<?>[] ftrs = new Future<?>[countProcessors - 1];
        for (int i = 0; i < countProcessors - 1; i++) {
            ftrs[i] = executor.submit(filesSearch);
        }
        while (!Arrays.stream(ftrs).allMatch(Future::isDone)) {
            Thread.sleep(1);
        }
        return search.fileList;
    }
}
