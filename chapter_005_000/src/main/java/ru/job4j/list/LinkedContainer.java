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
    private Node<E> first = null;
    private Node<E> last = null;

    private class Node<E> {
        E date;
        Node<E> next;
        public Node(E date) {
            this.date = date;
        }
    }

    @Override
    public void add(E value) {
        if (first == null) {
            first = new Node<E>(value);
            last = first;
        } else {
            last.next = new Node<E>(value);
            last = last.next;
        }
        modCount++;
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
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Container was changed");
                }
                return position < modCount;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) getNode(position++).date;
            }
        };
    }

    private Node<E> getNode(int index) {
        Node<E> tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
