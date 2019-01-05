package ru.job4j.pool;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by slevi on 05.01.2019.
 */
public class ThreadPoolTest {

    private ThreadPool th;
    public static final int SIZE = Runtime.getRuntime().availableProcessors();
    Thread[] threads;
    Runnable[] runnables = {
            () -> System.out.println("!! - >>0: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>1: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>2: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>3: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>4: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>5: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>6: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>7: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>8: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>9: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>10: " + Thread.currentThread().getName()),
            () -> System.out.println("!! - >>11: " + Thread.currentThread().getName())};

    @Before
    public void setUp() {
        th = new ThreadPool();
        threads = new Thread[SIZE];
        IntStream.range(0, SIZE).forEach((i) -> threads[i] = new Thread(new ThreadWork(th), "Thread #" + (i + 1)));
    }

    @Test
    public void work() throws InterruptedException {
        Runnable workR = () -> {
            IntStream.range(0, runnables.length).forEach((i) -> th.work(runnables[i]));
        };
        Runnable stopR = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                th.shutdown();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Thread work = new Thread(workR, "StartThread");
        Thread stop = new Thread(stopR, "StopThread");
        work.start();
        for (Thread t : threads) {
            t.start();
        }
        work.join();
        stop.start();
        for (Thread t : threads) {
            t.join();
        }
        stop.interrupt();
    }
}