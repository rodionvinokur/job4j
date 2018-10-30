package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenIt
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class EvenIt implements Iterator<Integer> {
    private int[] array;
    private int currentPosition = -1;

    public EvenIt(int[] array) {
        this.array = array;
        findNext();
    }

    public void findNext() {
        for (int i = currentPosition + 1; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                currentPosition = i;
                return;
            }
            currentPosition = -1;
        }
    }

    @Override
    public boolean hasNext() {
        return currentPosition != -1;
    }

    @Override
    public Integer next() {
        int result = -1;
        try {
            result = array[currentPosition];
            findNext();
        } catch (Exception m) {
            throw new NoSuchElementException(m.getMessage());
        }
        return result;
    }
}
