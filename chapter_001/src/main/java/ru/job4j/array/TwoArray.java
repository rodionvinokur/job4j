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
     * @param first[]
     * @param second[]
     * @return common[]
     */
    public int[] concat(int[] first, int[] second) {
        int[] common = new int[first.length + second.length];
        int indexFirst = 0;
        int indexSecond = 0;
        int indexCommon = 0;
        while (common.length - indexFirst - indexSecond > 0) {
            if ((indexSecond < second.length && indexFirst < first.length && first[indexFirst] > second[second.length - 1]) || (indexFirst == first.length)) {
                common[indexCommon++] = second[indexSecond++];
            } else {
                if ((indexFirst < first.length && indexSecond < second.length && second[indexSecond] > first[first.length - 1]) || (indexSecond == second.length)) {
                    common[indexCommon++] = first[indexFirst++];
                } else {
                    if (first[indexFirst] > second[indexSecond]) {
                        common[indexCommon++] = second[indexSecond++];
                    } else {
                        common[indexCommon++] = first[indexFirst++];
                    }
                }
            }
        }
        return common;
    }
}