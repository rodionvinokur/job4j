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
     * @param first  sort array.
     * @param second sort array.
     * @return common array = first merge second.
     */
    public int[] concat(int[] first, int[] second) {
        int[] common = new int[first.length + second.length];
        int indexFirst = 0;
        int indexSecond = 0;
        int indexCommon = 0;
        boolean fZerro = first.length == 0;
        boolean sZerro = second.length == 0;
        while (common.length > indexCommon) {
            boolean fFinish = first.length <= indexFirst;
            boolean sFinish = second.length <= indexSecond;
            if (first.length == 0 && second.length == 0) {
                break;
            }
            if (fZerro || sZerro || fFinish || sFinish) {
                common[indexCommon++] = (fZerro || fFinish) ? second[indexSecond++] : first[indexFirst++];
                continue;
            }
            common[indexCommon++] = (first[indexFirst] > second[indexSecond])
                    ? second[indexSecond++] : first[indexFirst++];
        }
        return common;
    }
}