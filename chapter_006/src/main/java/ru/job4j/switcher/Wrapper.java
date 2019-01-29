package ru.job4j.switcher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Wrapper
 * Класс обертка для строки.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Wrapper {
    private volatile String obj = "";

    private ReadWriteLock rwlock = new ReentrantReadWriteLock();

    /**
     * getObj()
     * Метод с блокировкой на чтение.
     *
     * @return
     */
    public String getObj() {
        rwlock.readLock().lock();
        try {
            return obj;
        } finally {
            rwlock.readLock().unlock();
        }
    }

    /**
     * setObj(String )
     * Метод с блокировкой на запись.
     *
     * @param obj
     */
    public void setObj(String obj) {
        try {
            while (!rwlock.writeLock().tryLock(5, TimeUnit.MILLISECONDS));
            try {
                this.obj = obj;
            } finally {
                rwlock.writeLock().unlock();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.obj = obj;
    }
}
