package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test for TwoArray
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class TwoArrayTest {
    /**
     * Test for Method  int[] concat(int[], int[]).
     */
    @Test
    public void whenSortsArraysFirstLikeSecondThenTwoArrayToOne() {
        TwoArray t = new TwoArray();
        int[] input1 = new int[]{1, 1, 2, 6};
        int[] input2 = new int[]{1, 1, 2, 6};
        int[] result = t.concat(input1, input2);
        int[] expect = new int[]{1, 1, 1, 1, 2, 2, 6, 6};
        assertThat(result, is(expect));
    }
    /**
     * Test for Method  int[] concat(int[], int[]).
     */
    @Test
    public void whenSortsArraysFirstGreaterSecondThenTwoArrayToOne() {
        TwoArray t = new TwoArray();
        int[] input1 = new int[]{1, 2, 3, 4};
        int[] input2 = new int[]{5, 6, 7, 8};
        int[] result = t.concat(input1, input2);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expect));
    }
    /**
     * Test for Method  int[] concat(int[], int[]).
     */
    @Test
    public void whenSortsArraysOneChar1ThenTwoArrayToOne() {
        TwoArray t = new TwoArray();
        int[] input1 = new int[]{1};
        int[] input2 = new int[]{5};
        int[] result = t.concat(input1, input2);
        int[] expect = new int[]{1, 5};
        assertThat(result, is(expect));
    }
    /**
     * Test for Method  int[] concat(int[], int[]).
     */
    @Test
    public void whenSortsArraysOneChar2ThenTwoArrayToOne() {
        TwoArray t = new TwoArray();
        int[] input1 = new int[]{1};
        int[] input2 = new int[]{1};
        int[] result = t.concat(input1, input2);
        int[] expect = new int[]{1, 1};
        assertThat(result, is(expect));
    }
    /**
     * Test for Method  int[] concat(int[], int[]).
     */
    @Test
    public void whenSortsArraysThenTwoArrayToOne() {
        TwoArray t = new TwoArray();
        int[] input1 = new int[]{1, 3, 4, 100, 200, 300};
        int[] input2 = new int[]{1, 2, 5, 6, 7, 8};
        int[] result = t.concat(input1, input2);
        int[] expect = new int[]{1, 1, 2, 3, 4, 5, 6, 7, 8, 100, 200, 300};
        assertThat(result, is(expect));
    }
    /**
     * Test for Method  int[] concat(int[], int[]).
     */
    @Test
    public void whenSortsArraysEmptyThenResultEmpty() {
        TwoArray t = new TwoArray();
        int[] input1 = new int[]{};
        int[] input2 = new int[]{};
        int[] result = t.concat(input1, input2);
        int[] expect = new int[]{};
        assertThat(result, is(expect));
    }
}
