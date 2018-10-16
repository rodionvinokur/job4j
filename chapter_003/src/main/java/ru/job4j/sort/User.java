package ru.job4j.sort;

/**
 * User
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.getAge());
    }

    @Override
    public String toString() {
        return "[" + this.age + "]";
    }
}
