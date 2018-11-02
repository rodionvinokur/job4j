package ru.job4j.list;

/**
 * Created by slevi on 02.11.2018.
 */
public class Stack<E> implements IStack<E> {
    private LinkedContainer<E> container = new LinkedContainer<>();

    @Override
    public E poll() {
        return container.poll();
    }

    @Override
    public void push(E value) {
        container.push(value);
    }
}
