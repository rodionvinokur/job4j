package ru.job4j.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by slevi on 24.12.2018.
 */
public class SimpleBlockingQueueTest {
    private SimpleBlockingQueue<Integer> queue;
    private TreeSet<Integer> tree = new TreeSet<>();

    private class ThreadOut implements Runnable {
        @Override
        public void run() {
            tree.add(queue.poll());
        }
    }

    private class ThreadIn implements Runnable {
        private final Integer in;

        public ThreadIn(final Integer in) {
            this.in = in;
        }

        @Override
        public void run() {
            queue.offer(in);
        }
    }

    @Before
    public void setUp() {
        queue = new SimpleBlockingQueue<>();

    }

    @Test
    public void offer() {
        int number = 1000;
        Integer[] expected = new Integer[number];
        Thread[] array = new Thread[number];
        for (int i = 0; i < number; i++) {
            new Thread(new ThreadIn(i)).start();
            array[i] = new Thread(new ThreadOut(), "MyPotok" + i);
            array[i].start();
            try {
                array[i].join();
            } catch (InterruptedException e) {

            }
            expected[i] = i;
        }
        assertArrayEquals(expected, tree.toArray());
    }
}