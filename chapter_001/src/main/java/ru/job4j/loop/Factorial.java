package ru.job4j.loop;

/**
 * Factorial
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Factorial {
    /**
     * Method calculate factorial for (a).
     *
     * @param a
     * @return factorial.
     */
    public long calc(int a) {
        long f = 1;
        for (int i = 1; i <= a; i++) {
            f *= i;
        }
        return f;
    }
}
