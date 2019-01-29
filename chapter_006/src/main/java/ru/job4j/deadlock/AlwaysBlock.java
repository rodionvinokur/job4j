package ru.job4j.deadlock;

/**
 * AlwaysBlock
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class AlwaysBlock {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        Runnable r1 = () -> {
            try {
                a.lockAndTryLock(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                b.lockAndTryLock(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(r1, "R1!!!!!!!").start();
        new Thread(r2, "R2!!!!!!!").start();
    }
}

