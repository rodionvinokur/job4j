package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Trst for FindLoop
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FindLoopTest {
    /**
     * Test found.
     */
    @Test
    public void whenFInd5InArrayWhereFirstElement5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Test not found.
     */
    @Test
    public void whenNotFoudThenMinusOne() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 8;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
