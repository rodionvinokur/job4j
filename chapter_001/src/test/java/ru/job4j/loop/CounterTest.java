package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Counter.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class CounterTest {

    /**
     * whenDiapasonFromZerroToZerroThenZerro.
     */
    @Test
    public void whenDiapasonFromZerroToZerroThenZerro() {
        Counter cnt = new Counter();
        int result = cnt.add(0, 0);
        assertThat(result, is(0));
    }

    /**
     * whenDiapasonFromZerroToMinusThenZerro.
     */
    @Test
    public void whenDiapasonFromZerroToMinusThenZerro() {
        Counter cnt = new Counter();
        int result = cnt.add(0, -10);
        assertThat(result, is(0));
    }
    /**
     * whenDiapasonFromZerroToTenThen30.
     */
    @Test
    public void whenDiapasonFromZerroToTenThen30() {
        Counter cnt = new Counter();
        int result = cnt.add(0, 10);
        assertThat(result, is(30));
    }

    /**
     * whenDiapasonFromOneToTenThen30.
     */
    @Test
    public void whenDiapasonFromOneToTenThen30() {
        Counter cnt = new Counter();
        int result = cnt.add(1, 10);
        assertThat(result, is(30));
    }
    /**
     * whenDiapasonFromTenToTenThen10.
     */
    @Test
    public void whenDiapasonFromTenToTenThen10() {
        Counter cnt = new Counter();
        int result = cnt.add(10, 10);
        assertThat(result, is(10));
    }
}
