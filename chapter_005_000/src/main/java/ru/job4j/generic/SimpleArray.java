package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleArray<T>
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SimpleArray<T> implements Iterable<T> {

    private T[] array;

    private int count = 0;

    public SimpleArray(T[] array) {
        this.array = array;
        count = array.length;
    }

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public boolean add(T model) {
        if (array == null || count == array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[count++] = model;
        return true;
    }

    public boolean set(int index, T model) {
        if (array != null && index < array.length) {
            array[index] = model;
            return true;
        }
        return false;
    }

    public boolean delete(int index) {
        if (array != null && index < array.length) {
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            array[array.length - 1] = null;
            count--;
            return true;
        }
        return false;
    }

    public T get(int index) {
        if (array != null && index < array.length) {
            return array[index];
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
            return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                if (array == null) {
                    throw new NullPointerException();
                }
                return position < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[position++];
            }
        };
    }
}
