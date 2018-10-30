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

    private List<T> list = null;

    public IteratorInt(T[] array) {
        this.array = array;
    }

    public IteratorInt(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (list == null) {
            return currentPosition < array.length;
        }
        return currentPosition < list.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list == null ? array[currentPosition++]
                : list.get(currentPosition++);
    }
}
