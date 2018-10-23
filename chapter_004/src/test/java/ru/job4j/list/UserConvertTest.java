package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * UserConvertTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class UserConvertTest {
    @Test
    public void testContainKey() {
        User usr1 = new User(1, "Masha", "Tallin");
        User usr2 = new User(2, "Boris", "London");
        User usr3 = new User(3, "Jon", "New-York");
        User usr4 = new User(4, "Gans", "Berlin");
        List<User> list = Arrays.asList(
                new User[]{usr1, usr2, usr3, usr4}
        );
        assertTrue(new UserConvert()
                .process(list)
                .containsKey(1));
    }

    @Test
    public void testContainValue() {
        User usr1 = new User(1, "Masha", "Tallin");
        User usr2 = new User(2, "Boris", "London");
        User usr3 = new User(3, "Jon", "New-York");
        User usr4 = new User(4, "Gans", "Berlin");
        List<User> list = Arrays.asList(
                new User[]{usr1, usr2, usr3, usr4}
        );
        assertTrue(new UserConvert()
                .process(list)
                .containsValue(usr3));
    }

    @Test
    public void testNotContainKey() {
        User usr1 = new User(1, "Masha", "Tallin");
        User usr2 = new User(2, "Boris", "London");
        User usr3 = new User(3, "Jon", "New-York");
        User usr4 = new User(4, "Gans", "Berlin");
        List<User> list = Arrays.asList(
                new User[]{usr1, usr2, usr3, usr4}
        );
        assertFalse(new UserConvert()
                .process(list)
                .containsKey(5));
    }
}
