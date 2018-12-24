package ru.job4j.queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by slevi on 24.12.2018.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    public synchronized void offer(T value) {
        queue.offer(value);
        notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        while (this.isEmpty() && !Thread.currentThread().isInterrupted()) {
         wait();
        }
        T t = (T) queue.poll();
        return t;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}