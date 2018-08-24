package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Trst for Square
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SquareTest {

    /**
     * Test for Method calculate(int);
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }
}

