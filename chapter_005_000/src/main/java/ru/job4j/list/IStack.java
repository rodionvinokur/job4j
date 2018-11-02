package ru.job4j.list;

/**
 * Created by slevi on 02.11.2018.
 */
public interface IStack<T> {
    public T poll();
    public void push(T value);
}
