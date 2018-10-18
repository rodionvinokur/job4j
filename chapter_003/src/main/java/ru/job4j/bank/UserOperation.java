package ru.job4j.bank;

import java.util.ArrayList;

/**
 * UserOperation
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class UserOperation implements IUserOp {
    private ILogic logic;

    public UserOperation(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void addUser(User user) {
        if (user != null) {
            logic.getAccounts().putIfAbsent(user, new ArrayList<Account>());
        }
    }

    @Override
    public void deleteUser(User user) {
        if (user != null) {
            logic.getAccounts().remove(user);
        }
    }
}
