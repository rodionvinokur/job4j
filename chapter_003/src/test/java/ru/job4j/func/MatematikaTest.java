package ru.job4j.func;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * MatematikaTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class MatematikaTest {
    @Test
    public void testLinear() {
        Matematika matem = new Matematika();
        List<Double> ld = matem.linear(1, 3);
        assertThat(ld, is(Arrays.asList(3D, 5D, 7D)));
    }

    @Test
    public void testQuadratic() {
        Matematika matem = new Matematika();
        List<Double> ld = matem.quadratic(1, 3);
        assertThat(ld, is(Arrays.asList(6D, 15D, 28D)));
    }

    @Test
    public void testLogarithmic() {
        Matematika matem = new Matematika();
        List<Double> ld = matem.logarithmic(1, 3);
        assertThat(ld, is(Arrays.asList(0D, 0.3010299956639812, 0.47712125471966244)));
    }
}
