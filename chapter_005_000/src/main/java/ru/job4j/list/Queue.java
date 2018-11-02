package ru.job4j.list;

/**
 * Created by slevi on 02.11.2018.
 */
public class Queue<E> implements IQueue<E> {
    private LinkedContainer<E> container = new LinkedContainer<>();

    @Override
    public E poll() {
        return container.pollLast();
    }

    @Override
    public void push(E value) {
        container.push(value);
    }
}
