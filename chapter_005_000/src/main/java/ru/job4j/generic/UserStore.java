package ru.job4j.generic;

/**
 * UserStore
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        setSimpleArray(new SimpleArray<>(10));
    }
}
