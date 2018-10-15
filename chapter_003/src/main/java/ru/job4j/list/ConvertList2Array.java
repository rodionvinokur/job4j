package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ConvertList2Array
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> lst, int rows) {
        if (!lst.isEmpty() && lst.size() >= rows) {
            int columns = lst.size() / rows + (lst.size() % rows > 0 ? 1 : 0);
            int[][] array = new int[rows][columns];
            int indexRow = 0;
            int indexColumn = 0;
            for (Integer element : lst) {
                array[indexRow][indexColumn++] = element;
                if (indexColumn == columns) {
                    indexColumn = 0;
                    indexRow++;
                }
            }
            return array;
        }
        return null;
    }
}