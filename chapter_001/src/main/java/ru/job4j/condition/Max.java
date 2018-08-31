package ru.job4j.condition;

/**
 * Max
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Max {
    /**
     * Method maximum from two numbers.
     *
     * @param a
     * @param b
     * @return maximum of (a, b)
     */
    public int max(int a, int b) {
        return a >= b ? a : b;
    }

    /**
     * Method maximum from three numbers.
     *
     * @param a
     * @param b
     * @param c
     * @return maximum.
     */
    public int max(int a, int b, int c) {
        return (max(max(a, b), c));
    }

}
