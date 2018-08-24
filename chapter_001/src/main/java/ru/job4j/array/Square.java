package ru.job4j.array;

/**
 * Square
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Square {
    /**
     * Method calculate.
     *
     * @param bound length of Array.
     * @return rst - Array.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index < rst.length; index++) {
            rst[index] = (index + 1) * (index + 1);
        }
        return rst;
    }
}
