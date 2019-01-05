package ru.job4j.pool;

import ru.job4j.queue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * ThreadPool
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public  void work(Runnable job) {
        tasks.offer(job);
    }

    public  Runnable extract() {
        Runnable job = null;
        try {
            job = tasks.poll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return job;
    }

    public  void shutdown() {
        tasks.offer(null);
    }
}
