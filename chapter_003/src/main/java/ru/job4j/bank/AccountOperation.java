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
            List<Account> srcListAccounts = getUserAccounts(srcPassport);
            Account srcUserAccount = new Account(srcRequisite);
            List<Account> dstListAccounts = getUserAccounts(dstPassport);
            Account dstUserAccount = new Account(dstRequisite);
            if (srcListAccounts != null && dstListAccounts != null) {
                Account srcAcc = srcListAccounts.get(srcListAccounts.indexOf(srcUserAccount));
                if (srcAcc.getValue() >= amount) {
                    Account dstAcc = dstListAccounts.get(dstListAccounts.indexOf(dstUserAccount));
                    srcAcc.setValue(srcAcc.getValue() - amount);
                    dstAcc.setValue(dstAcc.getValue() + amount);
                    result = true;
                }
            }

        }
        return result;
    }
}
