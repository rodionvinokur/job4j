package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test for Check
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class CheckTest {
    /**
     * Test for all TRUE.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));

        input = new boolean[] {true, true, true, true};
        result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test for different.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));

        input = new boolean[] {true, true, true, false};
        result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test for all FALSE.
     */
    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));

        input = new boolean[] {false, false, false, false};
        result = check.mono(input);
        assertThat(result, is(true));
    }
}
