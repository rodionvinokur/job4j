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
        boolean result = true;
        for (int index = 0; index < data.length; index++) {
            if (data[index] != data[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
