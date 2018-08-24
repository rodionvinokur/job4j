package ru.job4j.array;

/**
 * FindLoop
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FindLoop {
    /**
     * Method indexOf.
     *
     * @param data
     * @param el
     * @return
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
