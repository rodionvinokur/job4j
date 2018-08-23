package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Test for Triangle.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class TriangleTest {
    /**
     * Test when points on one line.
     */
    @Test
    public void whenTwoSideLesserThanOneThenFalse() {

        Point a = new Point(0, 1);
        Point b = new Point(0, 2);
        Point c = new Point(0, 3);

        Triangle t = new Triangle(a, b, c);
        assertFalse(t.isTriangle(1.0, 2.0, 4.0));
    }

    /**
     * Test when on different lines.
     */
    @Test
    public void whenTwoSideGreaterThanOneThenTrue() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 2);
        Point c = new Point(0, 3);

        Triangle t = new Triangle(a, b, c);
        assertTrue(t.isTriangle(2, 1, 2.4));
    }

    /**
     * Test area when not Triangle.
     */
    @Test
    public void whenNotTriangleThenMinusOne() {
        Point a = new Point(0, 1);
        Point b = new Point(0, 2);
        Point c = new Point(0, 3);

        Triangle t = new Triangle(a, b, c);
        assertThat(t.area(), closeTo(-1.0, 0.1));
    }

    /**
     * Test area when known Triangle.
     */
    @Test
    public void whenOkTriangleThenOkArea() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 3);
        Point c = new Point(3, 1);

        Triangle t = new Triangle(a, b, c);
        assertThat(t.area(), closeTo(2.0, 0.1));
    }
}
