package ru.job4j.container;

/**
 * IMContainer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface IMContainer<E> extends Iterable<E> {
    void add(E value);
    E get(int index);

}
