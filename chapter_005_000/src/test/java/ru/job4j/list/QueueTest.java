package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * StackTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class QueueTest {
    private IQueue<Integer> icQueue;

    @Before
    public void setUp() {
        icQueue = new Queue<>();
    }

    @Test
    public void whenNoPushPollNull() {
        assertTrue(icQueue.poll() == null);
        assertTrue(icQueue.poll() == null);
    }

    @Test
    public void whenPush123PollThen321() {
        icQueue.push(1);
        icQueue.push(2);
        icQueue.push(3);
        assertThat(icQueue.poll(), is(1));
        assertThat(icQueue.poll(), is(2));
        assertThat(icQueue.poll(), is(3));
        assertTrue(icQueue.poll() == null);
    }

}