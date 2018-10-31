package ru.job4j.generic;

/**
 * Store
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
