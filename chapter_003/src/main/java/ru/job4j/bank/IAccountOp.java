package ru.job4j.bank;

import java.util.List;

/**
 * IAccountOp
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface IAccountOp {
    public void addAccountToUser(String passport, Account account);

    public void deleteAccountFromUser(String passport, Account account);

    public List<Account> getUserAccounts(String passport);

    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String dstRequisite,
                                 double amount);
}
