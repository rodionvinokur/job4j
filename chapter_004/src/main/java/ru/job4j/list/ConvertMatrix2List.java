package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        for (int[] element : array) {
            list.addAll(Arrays.stream(element).boxed().collect(Collectors.toCollection(ArrayList::new)));
        }
        return list;
    }
}
