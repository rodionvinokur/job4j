package ru.job4j.array;

/**
 * BubbleSort
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class BubbleSort {
    /**
     * Method sort.
     *
     * @param array
     * @return array
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
