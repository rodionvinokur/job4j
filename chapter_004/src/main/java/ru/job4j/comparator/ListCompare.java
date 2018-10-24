package ru.job4j.comparator;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

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
        class StringWrapper {
            char[] chrRight;
            int position;

            StringWrapper(String str) {
                this.chrRight = str.toCharArray();
                int position = 0;
            }

            char nextRight() {
                return position < chrRight.length ? chrRight[position++] : 0;
            }

            void init() {
                position = 0;
            }
        }
        StringWrapper sw = new StringWrapper(right);
        int result = -1;

        int lenMin = Integer.min(left.length(), right.length());

        result = left.chars().mapToObj(x -> (char) x)
                .limit(lenMin)
                .map(x -> Integer.compare(x, sw.nextRight()))
                .filter(x -> x != 0).limit(1).reduce((acc, x) -> x).orElse(0);
        return result == 0
                ? Integer.compare(left.length(), right.length())
                : result;

    }
}
