package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleArrayListTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SimpleArrayListTest {

    private SimpleArrayList list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenSize0ResultOfDeleteIsNull() {
        list.delete();
        list.delete();
        list.delete();
        assertTrue(list.delete() == null);
    }

    @Test
    public void whenSize1ResultOfDeleteIsSize0() {
        list.delete();
        list.delete();
        assertTrue(list.getSize() == 1);
        list.delete();
        assertTrue(list.getSize() == 0);
    }

    @Test
    public void whenSizeMoreThan1ThenResultOfDeleteIsFirstElementWillSecond() {
        list.delete();
        assertThat(list.get(0), is(2));
    }
}
