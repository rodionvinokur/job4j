package ru.job4j.iter;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * IteratorInt<T>
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class IteratorInt<T> implements Iterator {
    private T[] array;
    private int currentPosition = 0;

    public IteratorInt(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
            return currentPosition < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[currentPosition++];
    }
}
