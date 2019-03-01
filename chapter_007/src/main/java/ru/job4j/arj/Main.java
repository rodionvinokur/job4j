package ru.job4j.arj;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Main
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
  //    String[] ar = {"-d tmp", "-e *.txt", "-o my.zip"};
  //    System.out.println(Arrays.toString(args));
        DoZip dz = new DoZip(
                new Args(Arrays.stream(args).collect(Collectors.joining(" ")))
        );
        int countProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(countProcessors);
        Runnable doSearch = dz::doSearch;
        Runnable zipWrite = dz::write;
        executor.submit(doSearch);
        Future<?>  ftrs = executor.submit(zipWrite);
        while (!ftrs.isDone()) {
            Thread.sleep(1);
        }
        executor.shutdown();
    }
}
