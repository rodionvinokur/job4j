package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * UserTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class UserTest {
    @Test
    public void testPrintMapUsers() {
        Map<User, Object> mapUsrO = new HashMap<>();
        User usr1 = new User("Petro", 1, new GregorianCalendar(2011, 1, 25));
        User usr2 = new User("Petro", 1, new GregorianCalendar(2011, 1, 25));
        String one = "one";
        String two = "two";
        mapUsrO.put(usr1, one);
        mapUsrO.put(usr2, two);
        System.out.println(mapUsrO);
    }
}