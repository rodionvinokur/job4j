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
    public void whenPointsOnOneLineThenFalse() {

        Point a = new Point(0, 1);
        Point b = new Point(0, 2);
        Point c = new Point(0, 3);

        Triangle t = new Triangle(a, b, c);
        assertFalse(t.isTriangle());

        a = new Point(1, 1);
        b = new Point(2, 1);
        c = new Point(3, 1);

        t = new Triangle(a, b, c);
        assertFalse(t.isTriangle());

        a = new Point(0, 0);
        b = new Point(0, 0);
        c = new Point(0, 0);

        t = new Triangle(a, b, c);
        assertFalse(t.isTriangle());

        a = new Point(0, 0);
        b = new Point(1, 1);
        c = new Point(2, 2);

        t = new Triangle(a, b, c);
        assertFalse(t.isTriangle());
    }

    /**
     * Test when on different lines.
     */
    @Test
    public void whenPointsOnDifferentLineThenTrue() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 2);
        Point c = new Point(0, 3);

        Triangle t = new Triangle(a, b, c);
        assertTrue(t.isTriangle());
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
