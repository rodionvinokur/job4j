package ru.job4j.bank;

import java.util.List;

/**
 * AccountOperation
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class AccountOperation implements IAccountOp {
    private ILogic logic;

    public AccountOperation(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void addAccountToUser(String passport, Account account) {
        if (passport != null && account != null) {
            List<Account> listAccounts = getUserAccounts(passport);
            boolean listNotNullAndNotSuchAccountYet = (listAccounts != null)
                    && !listAccounts.stream().anyMatch(account::equals);
            if (listNotNullAndNotSuchAccountYet) {
                listAccounts.add(account);
            }
        }
    }

    @Override
    public void deleteAccountFromUser(String passport, Account account) {
        if (passport != null && account != null) {
            List<Account> listAccounts = getUserAccounts(passport);
            boolean listNotNull = (listAccounts != null);
            if (listNotNull) {
                listAccounts.removeIf(account::equals);
            }
        }
    }

    @Override
    public List<Account> getUserAccounts(String passport) {
        return passport != null
                ? this.logic.getAccounts().get(new User(passport))
                : null;
    }

    @Override
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String dstPassport,
                                 String dstRequisite,
                                 double amount) {
        boolean result = false;
        if (srcPassport != null
                && srcRequisite != null
                && dstPassport != null
                && dstRequisite != null
                && amount > 0.0
                && (!srcRequisite.equals(dstRequisite)
                || (srcPassport.equals(dstPassport)
                && !srcRequisite.equals(dstRequisite)))) {
            Account srcAcc = getUserAccount(srcPassport, srcRequisite);
            if (srcAcc != null && srcAcc.getValue() >= amount) {
                Account dstAcc = getUserAccount(dstPassport, dstRequisite);
                if (dstAcc != null) {
                    srcAcc.setValue(srcAcc.getValue() - amount);
                    dstAcc.setValue(dstAcc.getValue() + amount);
                    result = true;
                }
            }
        }
        return result;
    }

    private Account getUserAccount(String userPassport, String accountRequisite) {
        if (userPassport == null || accountRequisite == null) {
            return null;
        }
        List<Account> listAccounts = getUserAccounts(userPassport);
        Account userAccount = new Account(accountRequisite);
        int index = listAccounts.indexOf(userAccount);
        return index != -1
                ? listAccounts.get(index)
                : null;
    }
}
