package ru.job4j.split;

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
    private int zerroCount;
    private Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
        }
    };

    public DestinationArray(int[] source) {
        this.dest = new Integer[source.length];
    }

    public Integer[] getArray() {
        if (zerroCount > 0) {
            Arrays.fill(dest, count, count + zerroCount, 0);
            count += zerroCount;
        }
        return Arrays.copyOfRange(dest, 0, count);
    }

    public int getSum() {
        return sum;
    }

    public int getSize() {
        return count;
    }

    public int getMin() {
        return dest[count - 1];
    }

    private int indexOf(int number) {
        return Arrays.binarySearch(dest, 0, count, number, comparator);
    }

    public void offer(int number) {
        if (number == 0) {
            zerroCount++;
            return;
        }
        int index = indexOf(number);
        index = index < 0 ? ~index : index;
        System.arraycopy(dest, index, dest, index + 1, count - index);
        dest[index] = number;
        sum += number;
        count++;
    }

    public int poll() {
        int result = dest[count - 1];
        count--;
        sum -= result;
        return result;
    }

    public DestinationArray minArray(DestinationArray arr) {
        return this.sum >= arr.getSum() ? arr : this;
    }

    public double getSumDifferent(DestinationArray arr2) {
        return Math.abs(arr2.getSum() - this.getSum()) * 1D;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.getArray());
    }

}
