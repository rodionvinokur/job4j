package ru.job4j.array;

/**
 * Turn
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Turn {
    /**
     * Method turn array.
     *
     * @param array
     * @return array
     */
    public int[] turn(int[] array) {
        int count = array.length / 2;
        for (int index = 0; index < count; index++) {
            int tmp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = tmp;
        }
        return array;
    }
}
