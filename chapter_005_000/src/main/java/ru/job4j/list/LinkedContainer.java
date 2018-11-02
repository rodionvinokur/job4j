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
public class LinkedContainer<E> implements IContainer<E>, IStack<E> {
    private int modCount = 0;
    private int size = 0;
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
    public void push(E value) {
        if (first == null) {
            first = new Node<E>(value);
            last = first;
        } else {
            Node<E> tmpNode = first;
            first = new Node<E>(value);
            first.next = tmpNode;
        }
        modCount++;
        size++;
    }

    @Override
    public E poll() {
        Node<E> result = first;
        first = (first != null) ? first.next : null;
        modCount++;
        size = size != 0 ? --size : 0;
        return result == null ? null : (E) result.date;
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
        size++;
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
                return position < size;
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
