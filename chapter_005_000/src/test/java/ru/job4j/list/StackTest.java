package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * StackTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class StackTest {
    private IStack<Integer> icStack;

    @Before
    public void setUp() {
        icStack = new Stack<>();
    }

    @Test
    public void whenNoPushPollNull() {
        assertTrue(icStack.poll() == null);
        assertTrue(icStack.poll() == null);
    }

    @Test
    public void whenPush123PollThen321() {
        icStack.push(1);
        icStack.push(2);
        icStack.push(3);
        assertThat(icStack.poll(), is(3));
        assertThat(icStack.poll(), is(2));
        assertThat(icStack.poll(), is(1));
        assertTrue(icStack.poll() == null);
    }

}