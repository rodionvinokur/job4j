package ru.job4j.loop;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test for Factorial
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FactorialTest {
    /**
     * whenZerroThenOne.
     */
    @Test
    public void whenZerroThenOne() {
        Factorial cnt = new Factorial();
        long result = cnt.calc(0);
        assertThat(result, is(1L));
    }

     /**
     * whenFiveThen120.
     */
    @Test
    public void whenFiveThen120() {
        Factorial cnt = new Factorial();
        long result = cnt.calc(5);
        assertThat(result, is(120L));
    }
}
