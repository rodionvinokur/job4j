package ru.job4j.condition;

/**
 * Test for Point.
 *
 * @author Rodion V.
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import ru.job4j.condition.Point;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
 * Test for Point.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class PointTest {
    /**
     * Test for Distance.
     */
    @Test
    public void whenP1andP2then2() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(3, 0);
        double dst = p1.distanceTo(p2);
        assertThat(dst, closeTo(2.0, 0.1));
    }
}
