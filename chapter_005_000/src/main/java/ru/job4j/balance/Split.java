package ru.job4j.balance;

import ru.job4j.balance.ComparatorReverseInteger;
import ru.job4j.balance.DestinationArray;

import java.util.Arrays;

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
    public void splitToSameArray(Integer[] source, DestinationArray left, DestinationArray right) {
        ComparatorReverseInteger comparator = new ComparatorReverseInteger();
        Arrays.sort(source, 0, source.length, comparator);
        for (Integer element : source) {
            DestinationArray min = left.minArray(right);
            min.offer(element);
        }

    }

}
