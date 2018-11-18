package ru.job4j.store;

/**
 * User
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class User implements Comparable<User> {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
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

        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        int idCompareResult = Integer.compare(this.getId(), o.getId());
        return idCompareResult != 0 ? idCompareResult : this.getName().compareTo(o.getName());
    }
}
