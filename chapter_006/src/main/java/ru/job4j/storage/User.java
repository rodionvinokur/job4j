package ru.job4j.storage;

/**
 * Created by slevi on 22.12.2018.
 */
public class User {
    private final int id;
    private final int amount;

    public User(final int id, final int amount) {
        this.amount = amount;
        this.id = id;
    }

    public User(final int id) {
        this.id = id;
        this.amount = 0;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
