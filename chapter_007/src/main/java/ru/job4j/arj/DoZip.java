package ru.job4j.arj;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * DoZip
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class DoZip {
    private final Queue<String> queue = new ConcurrentLinkedQueue<>();
    private final Args args;
    private volatile boolean stop = false;

    public DoZip(final Args args) {
        this.args = args;
    }

    public void doSearch() {
        String exclude = args.exclude();
        Queue<File> dirFind = new ArrayDeque<>();
        try {
            dirFind.add(new File(args.directory()));
        } catch (IllegalArgumentException iae) {
            stop = true;
        }
        while (!dirFind.isEmpty() && !stop) {
            File dirFromPoll = dirFind.poll();
            queue.add(dirFromPoll.getPath());
            for (File file : dirFromPoll.listFiles(f -> !f.getName().matches(exclude))) {
                if (file.isDirectory()) {
                    dirFind.add(file);
                } else {
                    queue.add(file.getPath());
                }
            }
        }
        stop = true;
    }

    public void write() {
        try (ZipOutputStream zout = new ZipOutputStream((new FileOutputStream(Paths.get(args.output()).toFile())))) {
            while (!(stop && queue.isEmpty())) {
                if (queue.isEmpty()) {
                    Thread.yield();
                }
                File file = new File(queue.poll());
                if (file.isDirectory()) {
                    zout.putNextEntry(new ZipEntry(file.getPath() + "/"));
                } else {
                    zipWrite(zout, file.getPath());
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void zipWrite(ZipOutputStream zout, String zipEntryFileName) throws IOException {
        zout.putNextEntry(new ZipEntry(zipEntryFileName));
        Files.copy(Paths.get(zipEntryFileName), zout);
    }
}
