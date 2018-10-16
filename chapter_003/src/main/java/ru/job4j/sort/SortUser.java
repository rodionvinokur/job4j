package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * SortUser
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<User>(list);
    }
}
