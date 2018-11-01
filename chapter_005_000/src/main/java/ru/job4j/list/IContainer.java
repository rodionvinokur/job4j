package ru.job4j.list;

/**
 * IContainer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface IContainer<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
