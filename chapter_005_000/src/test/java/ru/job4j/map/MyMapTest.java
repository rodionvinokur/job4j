package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by slevi on 04.11.2018.
 */
public class MyMapTest {
    private MyMap<Integer, String> map;

    @Before
    public void setUp() {
        map = new MyMap<>();
    }

    @Test
    public void whenInsertSimple32ThenCount32() {
        for (int i = 0; i < 32; i++) {
            map.insert(i, "Element #" + i);
        }
        int count = 0;
        Iterator<Integer> iter = map.iterator();
        while (true) {
            try {
                if (iter.hasNext()) {
                    count++;
                    iter.next();
                }
            } catch (NoSuchElementException m) {
                break;
            }
        }
        assertEquals(32, count);
        assertEquals("Element #21", map.get(21));
    }


    @Test
    public void whenInsertOneSimpleAndOneDuplicatekeyThenWillReWrite() {
        map.insert(1, "Element #1");
        assertEquals("Element #1", map.get(1));
        map.insert(1, "Element #2");
        assertEquals("Element #2", map.get(1));
        int count = 0;
        Iterator<Integer> iter = map.iterator();
        while (true) {
            try {
                if (iter.hasNext()) {
                    count++;
                    iter.next();
                }
            } catch (NoSuchElementException m) {
                break;
            }
        }
        assertEquals(1, count);
    }

    @Test
    public void whenInsertOneSimpleAndOneNullKeyThenCountOne() {
        map.insert(1, "Element #1");
        assertFalse(map.insert(null, "Element #2"));
        int count = 0;
        Iterator<Integer> iter = map.iterator();
        while (true) {
            try {
                if (iter.hasNext()) {
                    count++;
                    iter.next();
                }
            } catch (NoSuchElementException m) {
                break;
            }
        }
        assertEquals(1, count);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyMapThenCount0() {
        int count = 0;
        for (Integer key : map) {
            count++;
        }
        assertEquals(0, count);
    }

    @Test
    public void whenSimpleInsertTrue() {
        assertTrue(map.insert(1, "Element #1"));
    }

    @Test
    public void whenGetNotExistsElementThanNull() {
        map.insert(1, "Element #1");
        assertNull(map.get(2));
    }

    @Test
    public void whenDelete() {
        map.insert(1, "Element #1");
        assertNotNull(map.get(1));
        assertTrue(map.delete(1));
        assertNull(map.get(1));
    }

    @Test
    public void whenDeleteNotExists() {
        map.insert(1, "Element #1");
        assertFalse(map.delete(2));
    }

    @Test
    public void whenDeleteOnEmptyMap() {
        assertFalse(map.delete(2));
    }
}