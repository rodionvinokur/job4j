package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class MaxTest {

    /**
     * Test whenFirstLessSecond.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test whenFirstEqvSecond.
     */
    @Test
    public void whenFirstEqvSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 1);
        assertThat(result, is(1));
    }
    /**
     * whenFirstGreaterSecond.
     */
    @Test
    public void whenFirstGreaterSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }

    /**
     * whenFirstGreaterThenFirst.
     */
    @Test
    public void whenFirstGreaterThenFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1, 0);
        assertThat(result, is(2));
    }

    /**
     * whenSecondGreaterThenSecond.
     */
    @Test
    public void whenSecondGreaterThenSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 3, 0);
        assertThat(result, is(3));
    }

    /**
     * whenThreeGreaterThenThree.
     */
    @Test
    public void whenThreeGreaterThenThree() {
        Max maxim = new Max();
        int result = maxim.max(2, 3, 4);
        assertThat(result, is(4));
    }
}
