package ru.job4j.array;

/**
 * Check
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Check {
    /**
     * Method mono.
     *
     * @param data
     * @return
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length; index++) {
            if (index == 0) {
                result = data[0];
            } else {
                if (data[index] != result) {
                    result = data[index];
                    break;
                }
            }
        }
        return result == data[0];
    }
}
