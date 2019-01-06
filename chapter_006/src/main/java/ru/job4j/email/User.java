package ru.job4j.email;


/**
 * User
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class User {
    final private String name;
    final private String email;

    public User(final String name, final String email) {
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
