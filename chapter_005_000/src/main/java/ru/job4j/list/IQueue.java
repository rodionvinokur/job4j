package ru.job4j.list;

/**
 * Created by slevi on 02.11.2018.
 */
public interface IQueue<T> {
    public T poll();
    public void push(T value);
}
