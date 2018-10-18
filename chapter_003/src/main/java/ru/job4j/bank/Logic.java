package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Logic
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Logic implements ILogic, IOperation {
    private Map<User, List<Account>> accounts = new HashMap<>();

    private IUserOp usrOp = new UserOperation(this);
    private IAccountOp accOp = new AccountOperation(this);

    public Map<User, List<Account>> getAccounts() {
        return accounts;
    }

    @Override
    public void addUser(User user) {
        usrOp.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        usrOp.deleteUser(user);
    }

    @Override
    public void addAccountToUser(String passport, Account account) {
        accOp.addAccountToUser(passport, account);
    }

    @Override
    public void deleteAccountFromUser(String passport, Account account) {
        accOp.deleteAccountFromUser(passport, account);
    }

    @Override
    public List<Account> getUserAccounts(String passport) {
        return accOp.getUserAccounts(passport);
    }

    @Override
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String dstRequisite,
                                 double amount) {
        return accOp.transferMoney(srcPassport,
                srcRequisite,
                destPassport,
                dstRequisite,
                amount);
    }
}
