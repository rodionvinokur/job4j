package ru.job4j.comparator;

import java.util.Comparator;

/**
 * ListCompare
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] chrLeft = left.toCharArray();
        char[] chrRight = right.toCharArray();
        int result = 0;
        int lenMin = Integer.min(chrLeft.length, chrRight.length);
        for (int i = 0; i < lenMin; i++) {
            result = Integer.compare(chrLeft[i], chrRight[i]);
            if (result != 0) {
                break;
            }
        }
        return result == 0
                ? Integer.compare(chrLeft.length, chrRight.length)
                : result;
    }
}
