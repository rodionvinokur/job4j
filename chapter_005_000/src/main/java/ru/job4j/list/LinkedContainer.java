package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedContainer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class LinkedContainer<E> implements IContainer<E> {
    private int modCount;
    private int size = 0;
    private int capacity = 0;
    private Node<E> first = null;
    private Node<E> last = null;

    private class Node<E> {
        E date;
        Node<E> next;
    }

    public LinkedContainer(int delta) {
        expandContainer(delta);
    }

    public LinkedContainer() {
        expandContainer(10);
    }

    @Override
    public void add(E value) {
        if (size == capacity) {
            expandContainer(0);
            modCount++;
        }
        getNode(size++).date = value;
    }

    @Override
    public E get(int index) {
        return (E) getNode(index).date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            final int expectedModCount = modCount;
            int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Container was changed");
                }
                return (E) getNode(position++);
            }
        };
    }

    private Node<E> getNode(int index) {
        Node<E> tmp = first;
        for (int i = 0; i < size; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    private void expandContainer(int delta) {
        int incrementCapacity = delta == 0 ? capacity + 1 : delta;
        if (incrementCapacity > 0 && first == null) {
            first = new Node<E>();
            last = first;
            capacity++;
        }
        for (int i = 0; i < incrementCapacity - 1; i++) {
            Node<E> additionalNode = new Node<E>();
            last.next = additionalNode;
            last = additionalNode;
            capacity++;
        }
    }
}
