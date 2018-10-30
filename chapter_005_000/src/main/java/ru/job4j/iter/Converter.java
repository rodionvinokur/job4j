package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by slevi on 30.10.2018.
 */
public class Converter<T> {

    public Iterator<T> convert(Iterator<Iterator<T>> iterate) {

        return new Iterator<T>() {
            Iterator<T> iteratorT = iterate.next();

            @Override
            public boolean hasNext() {
                return iteratorT.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = iteratorT.next();
                while (!iteratorT.hasNext() && iterate.hasNext()) {
                    iteratorT = iterate.next();
                }
                return result;
            }
        };
    }
}