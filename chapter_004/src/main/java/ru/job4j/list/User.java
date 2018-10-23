package ru.job4j.list;

/**
 * User
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class User {
    private Integer id;
    private String name;
    private String city;

    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return this.id;
    }
}
