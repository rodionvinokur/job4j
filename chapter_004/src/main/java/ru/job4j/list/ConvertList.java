package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return list.stream()
                .map(x -> Arrays.stream(x)
                        .boxed().collect(Collectors.toCollection(ArrayList<Integer>::new))
                ).collect(ArrayList<Integer>::new,
                        ArrayList<Integer>::addAll, ArrayList<Integer>::addAll);
    }
}
