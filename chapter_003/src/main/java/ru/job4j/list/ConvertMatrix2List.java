package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertMatrix2List
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ConvertMatrix2List {
    /**
     * toList
     *
     * @param array array of int[][], if array is null then NPE
     * @return ArrayList
     */
    public List<Integer> toList(int[][] array) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        List<Integer> list = new ArrayList<>();
        for (int indexRow = 0; indexRow < array.length; indexRow++) {
            for (int indexColumn = 0; indexColumn < array[indexRow].length;
                 indexColumn++) {
                list.add(array[indexRow][indexColumn]);
            }
        }
        return list;
    }
}
