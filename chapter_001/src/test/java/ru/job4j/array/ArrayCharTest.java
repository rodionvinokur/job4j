package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for ArrayChar
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ArrayCharTest {
    /**
     * Test when true.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }
    /**
     * Test when false.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));

        result = word.startWith("Hello!");
        assertThat(result, is(false));

        result = word.startWith("lll");
        assertThat(result, is(false));
    }
}
