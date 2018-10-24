package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * SortUser
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        return list.stream().collect(Collectors.toCollection(TreeSet::new));
    }

    public List<User> sortNameLength(List<User> list) {
        return list.stream()
                .sorted(Comparator.comparing(User::getNameLength)).collect(Collectors.toList());
    }

    public List<User> sortByAllFields(List<User> list) {
        return list.stream().sorted(Comparator.comparing(User::getName)
                .thenComparing(User::getAge)).collect(Collectors.toList());
    }
}
