package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test for Turn
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class TurnTest {
    /**
     * Test for even numbers of elements.
     */
    @Test
    public void whenTurnArrayWithEvenOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.turn(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    /**
     * Test for odd numbers of elements.
     */
    @Test
    public void whenTurnArrayWithOddOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2, 5};
        int[] result = turner.turn(input);
        int[] expect = new int[] {5, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}
