package ru.job4j.storage;

import net.jcip.annotations.ThreadSafe;

import java.util.*;

/**
 * Created by slevi on 22.12.2018.
 */
@ThreadSafe
public class UserStorage {
    private final List<User> users = Collections.synchronizedList(new ArrayList<User>());

    public synchronized boolean add(User user) {
        if (user != null && !users.contains(user)) {
            return users.add(user);
        }
        return false;
    }

    public synchronized boolean update(User user) {
        int index = users.indexOf(user);
        if (index > -1) {
            users.set(index, user);
            return true;
        }
        return false;
    }

    public synchronized boolean delete(User user) {
        return users.remove(user);
    }

    public synchronized void transfer(final int fromId, final int toId, int amount) {
        int indexFrom = users.indexOf(new User(fromId));
        int indexTo = users.indexOf(new User(toId));
        if (indexFrom < 0 || indexTo < 0) {
            return;
        }
        User userFrom = users.get(indexFrom);
        User userTo = users.get(indexTo);
        int amountFrom = userFrom.getAmount() - amount;
        if (amountFrom < 0) {
            return;
        }
        userFrom = new User(userFrom.getId(), amountFrom);
        this.update(userFrom);
        int amountTo = userTo.getAmount() + amount;
        userTo = new User(userTo.getId(), amountTo);
        this.update(userTo);
    }
}
