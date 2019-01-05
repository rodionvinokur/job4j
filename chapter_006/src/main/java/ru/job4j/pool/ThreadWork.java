package ru.job4j.pool;

/**
 * Created by slevi on 05.01.2019.
 */
public class ThreadWork implements Runnable {
    private final ThreadPool pool;

    public ThreadWork(final ThreadPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        do {
            Runnable r = pool.extract();
            if (r == null) {
                break;
            }
            r.run();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        while (!Thread.currentThread().isInterrupted());
    }
}
