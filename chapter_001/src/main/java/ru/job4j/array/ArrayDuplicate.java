package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ArrayDuplicate {
    /**
     * Method remove duplicate in String[].
     *
     * @param array
     * @return
     */
    public String[] remove(String[] array) {
        int count = array.length;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (array[i].equals(array[j])) {
                    for (int k = count - 1; k >= j; k--) {
                        if (!array[j].equals(array[k])) {
                            array[j] = array[k];
                            count--;
                            break;
                        } else {
                            count--;
                        }
                    }
                }
            }
        }
        return Arrays.copyOf(array, count);
    }
}
