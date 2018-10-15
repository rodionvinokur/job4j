package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ConvertList
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ConvertList {
    /**
     * convert
     *
     * @param list : List<int[]> to List<Integer>
     * @return
     */
    public List<Integer> convert(List<int[]> list) {
        ConvertMatrix2List util = new ConvertMatrix2List();
        List<Integer> targetList = new ArrayList<>();
        for (int[] element : list) {
            targetList.addAll(util.toList(simpleToMatrix(element)));
        }
        return targetList;
    }

    /**
     * simpleToMatrix convert int[] to int[1][]
     *
     * @param array
     * @return
     */
    private int[][] simpleToMatrix(int[] array) {
        int[][] result = new int[1][];
        result[0] = array;
        return result;
    }
}
