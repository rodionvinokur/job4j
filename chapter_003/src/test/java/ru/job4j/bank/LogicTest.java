package ru.job4j.bank;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by slevi on 17.10.2018.
 */
public class LogicTest {
    @Test
    public void testTransferWhenSufficientlyMoney() {
        IOperation logic = new Logic();
        logic.addUser(new User("Boris", "XXZZ-01"));
        logic.addUser(new User("Misha", "XXZZ-02"));
        logic.addUser(new User("German", "XXZZ-03"));
        logic.addAccountToUser("XXZZ-01", new Account(30, "1234"));
        logic.addAccountToUser("XXZZ-02", new Account(20, "12345"));
        logic.addAccountToUser("XXZZ-03", new Account(10, "123456"));

        logic.transferMoney("XXZZ-01",
                "1234",
                "XXZZ-02",
                "12345",
                20);

        assertTrue(logic.transferMoney("XXZZ-02",
                "12345",
                "XXZZ-03",
                "123456",
                35));
    }

    @Test
    public void testTransferWhenNotSufficientlyMoney() {
        IOperation logic = new Logic();
        logic.addUser(new User("Boris", "XXZZ-01"));
        logic.addUser(new User("Misha", "XXZZ-02"));
        logic.addUser(new User("German", "XXZZ-03"));
        logic.addAccountToUser("XXZZ-01", new Account(30, "1234"));
        logic.addAccountToUser("XXZZ-02", new Account(20, "12345"));
        logic.addAccountToUser("XXZZ-03", new Account(10, "123456"));

        assertFalse(logic.transferMoney("XXZZ-02",
                "12345",
                "XXZZ-03",
                "123456",
                35));
    }

    @Test
    public void testAddUser() {
        IOperation logic = new Logic();
        logic.addUser(new User("Boris", "XXZZ-01"));
        assertFalse(logic.getUserAccounts("XXZZ-01") == null);
    }

    @Test
    public void testDeletUser() {
        IOperation logic = new Logic();
        logic.addUser(new User("Boris", "XXZZ-01"));
        logic.deleteUser(new User("XXZZ-01"));
        assertTrue(logic.getUserAccounts("XXZZ-01") == null);
    }

    @Test
    public void testAddAccountToUser() {
        IOperation logic = new Logic();
        logic.addUser(new User("Boris", "XXZZ-01"));
        logic.addAccountToUser("XXZZ-01", new Account(30, "1234"));
        assertTrue(logic.getUserAccounts("XXZZ-01").stream().anyMatch(
                new Account(30, "1234")::equals
        ));
    }

    @Test
    public void testDeleteAccountFromUser() {
        IOperation logic = new Logic();
        Account testAccountForBoris = new Account(30, "1234");
        logic.addUser(new User("Boris", "XXZZ-01"));
        logic.addAccountToUser("XXZZ-01", testAccountForBoris);
        assertTrue(logic.getUserAccounts("XXZZ-01").stream().anyMatch(
                new Account(30, "1234")::equals
        ));
        logic.deleteAccountFromUser("XXZZ-01", testAccountForBoris);
        assertFalse(logic.getUserAccounts("XXZZ-01").stream().anyMatch(
                testAccountForBoris::equals
        ));
    }
}
