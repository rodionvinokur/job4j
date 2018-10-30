package ru.job4j.iter;

import java.util.*;

/**
 * IteratorIter<T>
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class IteratorIter<T> implements Iterator {
    private Iterator<T>[] array;
    private int currentPosition = 0;

    public IteratorIter(Iterator<T>[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < array.length;
    }

    @Override
    public Iterator<T> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[currentPosition++];
    }

    public Iterator<T> convert(Iterator<Iterator<T>> iterate) {
        return new Iterator<T>() {
            Iterator<T> iteratorT = iterate.next();
            @Override
            public boolean hasNext() {
                  return iterate.hasNext() || (!iterate.hasNext() && iteratorT.hasNext());
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (!iteratorT.hasNext()) {
                    iteratorT = iterate.next();
                }
                return iteratorT.next();
            }
        };
    }
}
