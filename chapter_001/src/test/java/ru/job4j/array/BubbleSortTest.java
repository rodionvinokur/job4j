package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for BubbleSort
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class BubbleSortTest {
    /**
     * Test for sort
     */
    @Test
    public void whenNoThenYes() {
        BubbleSort bs = new BubbleSort();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = bs.sort(input);
        int[] expect = new int[] {1, 2, 4, 6};
        assertThat(result, is(expect));

        input = new int[] {7, 2, 4, 6, 5, 0, 1};
        result = bs.sort(input);
        expect = new int[] {0, 1, 2, 4, 5, 6, 7};
        assertThat(result, is(expect));
    }
}
