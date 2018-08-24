package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test for Matrix
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class MatrixTest {
    /**
     * Test when 3
     */
    @Test
    public void when3Then123246369() {
        Matrix m = new Matrix();
        int input = 3;
        int[][] result = m.multiple(input);
        int[][] expect = new int[][] {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result, is(expect));
   }
    /**
     * Test when 1
     */
    @Test
    public void when1Then1() {
        Matrix m = new Matrix();
        int input = 1;
        int[][] result = m.multiple(input);
        int[][] expect = new int[][] {{1}};
        assertThat(result, is(expect));
    }
    /**
     * Test when 0
     */
    @Test
    public void when0ThenEmpty() {
        Matrix m = new Matrix();
        int input = 0;
        int[][] result = m.multiple(input);
        int[][] expect = new int[][]{{}};
        assertThat(result, is(expect));
    }
}
