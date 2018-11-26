package ru.job4j.split;

import java.util.Set;
import java.util.TreeSet;

/**
 * Split - утилитный класс для
 * разделенеия масива на две части равные или приблизительно равные по сумме
 * ограничения элементы входящего массива >= 0
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Split {

    /**
     * Метод splitToSameArray
     * производит итерацию по элементам входящего массива
     * помещает текущий элемент в массив с минимальной суммой элементов.
     * После этого вызывает балансировкую.
     * TreeSet необходим для выявления и останова цикличности алгоритма и получения минимальной разности сумм.
     *
     * @param source
     * @param left
     * @param right
     */
    public void splitToSameArray(int[] source, DestinationArray left, DestinationArray right) {
        Set<Double> set = new TreeSet<>();
        for (Integer element : source) {
            DestinationArray min = left.minArray(right);
            min.offer(element);
        }
        doBalance(left, right, set);
    }

    /**
     * Метод балансировки
     *
     * @param left
     * @param right
     * @param set
     */
    public void doBalance(DestinationArray left, DestinationArray right, Set<Double> set) {
        DestinationArray min = left.minArray(right);
        DestinationArray max = min == left ? right : left;
        if (min.getSize() == 0 || max.getSize() < 2) {
            return;
        }
        double calcDifferent = min.getSumDifferent(max);
        int size = set.size();
        set.add(calcDifferent);
        if (calcDifferent == 0
                || calcDifferent == Integer.min(max.getMin(), min.getMin())
                || (set.size() == size && calcDifferent == set.iterator().next() && max.getMin() > calcDifferent)) {
            return;
        }
            min.offer(max.poll());
            doBalance(min, max, set);
    }
}
