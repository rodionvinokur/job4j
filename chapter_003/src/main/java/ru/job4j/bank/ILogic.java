package ru.job4j.bank;

import java.util.List;
import java.util.Map;

/**
 * ILogic
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface ILogic {
    public Map<User, List<Account>> getAccounts();
}
