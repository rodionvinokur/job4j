package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Store
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Store {
    private List<User> currentUsers = new ArrayList<>();
    private List<User> previousUsers = new ArrayList<>();

    public Info<User> getDiff() {
        return new Info<>(currentUsers, previousUsers);
    }

    public void snapshot() {
        previousUsers.clear();
        previousUsers.addAll(currentUsers);
    }

    public void add(User usr) {
        if (usr != null) {
            for (int index = 0; index < currentUsers.size(); index++) {
                if (currentUsers.get(index).equals(usr)) {
                    currentUsers.set(index, usr);
                    break;
                }
            }
            currentUsers.add(usr);
        }
    }

    public void delete(User usr) {
        if (usr != null) {
            currentUsers.remove(usr);
        }
    }

}
