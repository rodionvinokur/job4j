package ru.job4j.email;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * EmailNotificationTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class EmailNotificationTest {
    private EmailNotification note;
    private User[] users = {
            new User("Vasya", "vs@mail.ru"),
            new User("Borya", "br@mail.ru"),
            new User("Masya", "ms@mail.ru"),
            new User("Lasya", "ls@mail.ru"),
            new User("Sasya", "ss@mail.ru"),
            new User("Dasya", "ds@mail.ru"),
            new User("Rasya", "rs@mail.ru"),
            new User("Fasya", "fs@mail.ru"),
            new User("Jasya", "js@mail.ru"),
            new User("Kasya", "ks@mail.ru")
    };


    @Before
    public void setUp() {
        note = new EmailNotification();
    }

    @Test
    public void emailTo() {
        for (User usr : users) {
            note.emailTo(usr);
        }

        note.close();
    }

}