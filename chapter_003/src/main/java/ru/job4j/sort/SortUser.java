package ru.job4j.sort;

import java.util.*;

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

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(
                        o1.getName().length(),
                        o2.getName().length()
                );
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }.thenComparing(new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                })
        );
        return list;
    }
}
