package ru.job4j.store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * InfoTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class InfoTest {
    Store suser;
    User usr1;
    User usr2;
    User usr3;
    User usr4;
    User usr5;
    User usr6;
    User usr7;
    User usr8;
    User usr9;

    @Before
    public void setUp() {
        suser = new Store();
        usr1 = new User(1, "Vasya");
        usr2 = new User(2, "Petya");
        usr3 = new User(3, "Mitya");
        usr4 = new User(4, "Volya");
        usr5 = new User(5, "German");
        usr6 = new User(5, "Boris");
        usr7 = new User(4, "Mels");
        usr8 = new User(8, "Bernard");
        usr9 = new User(9, "Misha");
        suser.add(usr1);
        suser.add(usr2);
        suser.add(usr3);
        suser.add(usr4);
        suser.add(usr5);
        suser.snapshot();
    }

    @Test
    public void whenAdd2ThenAdded2() {
        suser.add(usr8);
        suser.add(usr9);
        Info<User> info = suser.getDiff();
        assertEquals(2, info.getAdded());
    }

    @Test
    public void whenDelete2ThenDeleted2() {
        suser.delete(usr1);
        suser.delete(usr2);
        Info<User> info = suser.getDiff();
        assertEquals(2, info.getDeleted());
    }

    @Test
    public void whenChanged2ThenChanged2() {
        suser.add(usr6);
        suser.add(usr7);
        Info<User> info = suser.getDiff();
        assertEquals(2, info.getChanged());
    }

    @Test
    public void whenNotActionsThen0() {
        Info<User> info = suser.getDiff();
        assertEquals(0, info.getChanged() + info.getAdded() + info.getDeleted());
    }
}