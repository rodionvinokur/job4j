package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Container
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Container<E> implements IContainer<E> {
    private E[] container;
    private int modCount;
    private int count = 0;

    public Container(int size) {
        container = (E[]) new Object[size];
    }

    @Override
    public void add(E value) {
        if (count == container.length) {
            expandContainer();
            modCount++;
        }
        container[count++] = value;
    }

    @Override
    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            final int expectedModCount = modCount;
            int position = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Container was changed");
                }
                return position < count;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[position++];
            }
        };
    }

    private void expandContainer() {
        container = (E[]) Arrays.copyOf(container, container.length * 2 + 1);
    }
}
