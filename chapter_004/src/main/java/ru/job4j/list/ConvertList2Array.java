package ru.job4j.list;

import java.util.List;

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
            Matrix max = new Matrix(new int[rows][columns]);
            lst.stream().forEach(x->max.addNext(x));
            return max.getArray();
        }
        return null;
    }
}