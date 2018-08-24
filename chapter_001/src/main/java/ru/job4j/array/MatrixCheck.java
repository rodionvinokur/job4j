package ru.job4j.array;

/**
 * MatrixCheck
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class MatrixCheck {
    /**
     * Method mono(boolean[]).
     *
     * @param data
     * @return
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]
                    || data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
