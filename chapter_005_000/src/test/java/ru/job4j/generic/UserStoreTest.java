package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * UserStoreTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class UserStoreTest extends AbstractStore {
    private UserStore uStore;

    @Before
    public void setUp() throws Exception {
        uStore = new UserStore(10);
    }

    @Test
    public void whenAddUserWithId1ThenFindByIdTrue() throws Exception {
        uStore.add(new User("id1"));
        uStore.add(new User("id2"));
        assertTrue(uStore.findById("id1").equals(new User("id1")));
    }

    @Test
    public void whenNotAddUserWithId1ThenFindByIdNull() throws Exception {
        uStore.add(new User("id3"));
        uStore.add(new User("id2"));
        assertTrue(uStore.findById("id1") == null);
    }

    @Test
    public void whenReplaceFromID1ToID2ThenFindID2() throws Exception {
        uStore.add(new User("id1"));
        uStore.replace("id1", new User("id2"));
        assertTrue(uStore.findById("id2").equals(new User("id2")));
    }

    @Test
    public void whenAddID1AfterDeleteID1ThenFindNull() throws Exception {
        uStore.add(new User("id1"));
        uStore.delete("id1");
        assertTrue(uStore.findById("id1") == null);
    }
}