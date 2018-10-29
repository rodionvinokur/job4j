package ru.job4j.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Dictionary
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Dictionary {
    private List<Department> list = new ArrayList<>();
    private Set<String> hash = new HashSet<>();

    public void add(Department dep) {
        if (!hash.contains(dep.getDepName())) {
            String[] depNameArray = dep.getDepName().split("\\\\");
            String name = "";
            for (String str : depNameArray) {
                name += name.isEmpty() ? str : "\\" + str;
                if (hash.add(name)) {
                    list.add(new Department(name));
                }
            }
        }
    }

    public Dictionary sort() {
        Collections.sort(list);
        return this;
    }

    public Dictionary reverse() {
        list.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.reverseCompareTo(o2);
            }
        });
        return this;
    }

    public void print() {
        this.list.stream().forEach(System.out::println);
    }
}