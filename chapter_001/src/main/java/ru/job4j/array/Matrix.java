package ru.job4j.array;

/**
 * Matrix
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Matrix {
    /**
     * Multiply table.
     *
     * @param size
     * @return table
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        if (size <= 0) {
            table = new int[][]{{}};
        }
        return table;
    }
}
