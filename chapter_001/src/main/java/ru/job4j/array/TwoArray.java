package ru.job4j.array;
/**
 * TwoArray
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
class TwoArray {
    /**
     * Method concat for two sort arrays.
     *
     * @param a
     * @param b
     * @return
     */
    public int[] concat(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (c.length - i - j > 0) {
            if ((j < b.length && i < a.length && a[i] > b[b.length - 1]) || (i == a.length)) {
                c[k++] = b[j++];
            } else {
                if ((i < a.length && j < b.length && b[j] > a[a.length - 1]) || (j == b.length)) {
                    c[k++] = a[i++];
                } else {
                    if (a[i] > b[j]) {
                        c[k++] = b[j++];
                    } else {
                        c[k++] = a[i++];
                    }
                }
            }
        }
        return c;
    }
}