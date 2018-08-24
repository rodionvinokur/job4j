package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test for MatrixCheck
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class MatrixCheckTest {
    /**
     * Test when true.
     */
    @Test
    public void whenDataMonoThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));

        input = new boolean[][]{
                {true, false},
                {false, true}
        };
        result = check.mono(input);
        assertThat(result, is(true));

    }
    /**
     * Test when false.
     */
    @Test
    public void whenDataNotMonoThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));

        input = new boolean[][]{
                {true, false},
                {true, true}
        };
        result = check.mono(input);
        assertThat(result, is(false));
    }
}