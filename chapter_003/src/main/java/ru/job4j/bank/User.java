package ru.job4j.bank;

/**
 * User
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public User(String passport) {
        this.name = "HELPER";
        this.passport = passport;
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
        return getPassport().equals(user.getPassport());
    }

    @Override
    public int hashCode() {
        return getPassport().hashCode();
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int compareTo(User o) {
        return this.passport.compareTo(o.getPassport());
    }
}
