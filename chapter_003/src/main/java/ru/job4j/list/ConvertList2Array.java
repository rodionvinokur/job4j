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
            List<Integer> list = new ArrayList<>(lst);
            int columns = lst.size() / rows + (list.size() % rows > 0 ? 1 : 0);
            IntStream.range(0, rows * columns - lst.size()).forEach(x -> list.add(0));
            int i = 0;
            int index = 0;
            int[][] array = new int[rows][];
            for (int[] element : array) {
                array[i] = list.subList(index, index + columns)
                        .stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
                index += columns;
                i++;
            }
            return array;
        }
        return null;
    }
}