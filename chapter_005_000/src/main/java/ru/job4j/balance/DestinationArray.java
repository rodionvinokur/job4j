package ru.job4j.balance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * DestinationArray
 *
 * Класс обертка массива приемника
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class DestinationArray {
    private Integer[] dest;
    private int sum;
    private int count;
    private Comparator<Integer> comparator = new ComparatorReverseInteger();
    public DestinationArray(Integer[] source) {
        this.dest = new Integer[source.length];
    }

    public Integer[] getArray() {
        return Arrays.copyOfRange(dest, 0, count);
    }

    public int getSum() {
        return sum;
    }

    public int getSize() {
        return count;
    }

    private int indexOf(int number) {
        return Arrays.binarySearch(dest, 0, count, number, comparator);
    }

    public void offer(int number) {
        int index = indexOf(number);
        index = index < 0 ? ~index : index;
        System.arraycopy(dest, index, dest, index + 1, count - index);
        dest[index] = number;
        sum += number;
        count++;
    }

    public DestinationArray minArray(DestinationArray arr) {
        return this.sum >= arr.getSum() ? arr : this;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.getArray());
    }
}
