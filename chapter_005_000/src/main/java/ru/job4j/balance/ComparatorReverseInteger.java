package ru.job4j.balance;

import java.util.Comparator;

/**
 * Created by slevi on 26.11.2018.
 */
public class ComparatorReverseInteger implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return -Integer.compare(o1, o2);
    }
}
