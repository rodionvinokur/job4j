package ru.job4j.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

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
            try {
                tree.add(queue.poll());
            } catch (InterruptedException e) {

            }
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
        int number = 10000;
        Integer[] expected = new Integer[number];
        Thread[] array = new Thread[number];
        for (int i = 0; i < number; i++) {
            new Thread(new ThreadIn(i), "MyPotokIN" + i).start();
            array[i] = new Thread(new ThreadOut(), "MyPotokOUT" + i);
            array[i].start();
            try {
                array[i].join();
            } catch (InterruptedException e) {

            }
            expected[i] = i;
        }
        assertArrayEquals(expected, tree.toArray());
    }

    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final List<Integer> buffer = Collections.synchronizedList(new ArrayList<>());
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Runnable rp = () -> IntStream.range(0, 5).forEach(queue::offer);
        Runnable cp = () -> {
            while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                try {
                    buffer.add(queue.poll());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Thread producer = new Thread(rp);
        producer.start();
        Thread consumer = new Thread(cp);
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        Integer[] test = buffer.toArray(new Integer[0]);
        Arrays.sort(test);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, test);
    }
}