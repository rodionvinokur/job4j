package ru.job4j.deadlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class A {
    private ReentrantLock lock = new ReentrantLock();
    private CountDownLatch cdl = new CountDownLatch(1);

    /**
     * Метод lockAndTryLock
     * 1. Позволяет потоку R1 (описан в main) захватить блокировку на объекте (а - описан в main) ,
     * Второй объект (b - описан в main) блокировки закрыт синхронизатором CountDownLatch.
     * 2. После захвата блокировки на своем объекте, снимается баръер синхронизатора для потока R2.
     * Теперь R2 может попытаться захватить блокировку уже захваченную блокировку объекта (а).
     * При попытке захвата будет DeadLock
     * 3. То же самое верно и для второго потока R2.
     *
     * @param b
     * @throws InterruptedException
     */
    public void lockAndTryLock(A b) throws InterruptedException {
        lock.lock();
        CountDownLatch bCdl = b.getCdl();
        ReentrantLock bLock = b.getLock();
        bCdl.countDown();
        try {
            cdl.await();
            bLock.lock();
            try {

            } finally {
                bLock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public CountDownLatch getCdl() {
        return cdl;
    }
}
