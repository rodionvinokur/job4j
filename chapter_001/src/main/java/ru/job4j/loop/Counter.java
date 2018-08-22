package ru.job4j.loop;

/**
 * Counter for parity numbers
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Counter {

    /**
     * Amount of parity numbers in diapason.
     *
     * @param start - from.
     * @param finish - to.
     * @return amount
     */
    public int add(int start, int finish) {

        int amount = 0;

        start = (start % 2) == 0 ? start : start + 1;

        for (; start <= finish; start += 2) {
            amount += start;
        }

        return amount;
    }
}
