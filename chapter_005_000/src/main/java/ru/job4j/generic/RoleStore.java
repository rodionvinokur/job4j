package ru.job4j.generic;

/**
 * RoleStore
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class RoleStore extends AbstractStore<Role> {
    public RoleStore(int size) {
        setSimpleArray(new SimpleArray<>(10));
    }
}
