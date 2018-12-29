package ru.job4j.cache;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by slevi on 26.12.2018.
 */
public class StorageTest {
    Base[] bases = {
            new Base(1, 0, "First"),
            new Base(2, 0, "Second"),
            new Base(3, 0, "Three"),
            new Base(4, 0, "Four")
    };

    Storage store;

    @Before
    public void setUp() {
        store = new Storage();
        for (Base b : bases) {
            store.add(b);
        }
    }

    @Test
    public void replace() {
        int id = 1;
        int number = 2;
        AtomicReference<Exception> ex = new AtomicReference<>();
        do {
            number = number * 10;
            Thread[] array = new Thread[number];
            Runnable r = () -> {
                try {
                    store.update(new Base(id, 0, Thread.currentThread().getName()));
                } catch (OptimisticException ie) {
                    ex.set(ie);
                }
            };
            IntStream.range(0, number).forEach((i) -> array[i] = new Thread(r));
            IntStream.range(0, number).forEach((i) -> {
                array[i].start();
            });
            for (Thread t : array) {
                try {
                    t.join();
                } catch (InterruptedException ie) {
                    System.out.println("Exception");
                }
            }
        }
        while (ex.get() == null);
        assertEquals("Throw Exception in Thread", ex.get().getMessage());
    }
}