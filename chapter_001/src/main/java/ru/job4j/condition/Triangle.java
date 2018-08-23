package ru.job4j.condition;

/**
 * Triangle
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * Constructor.
     *
     * @param a - Point.
     * @param b - Point.
     * @param c - Point.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Area of Triangle.
     *
     * @return Area as double or -1.
     */
    public double area() {
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);

        if (!isTriangle(ab, ac, bc)) {
            return -1;
        }
        double pHalf = (ab + ac + bc) / 2;
        return Math.sqrt(pHalf * (pHalf - ab) * (pHalf - bc) * (pHalf - ac));
    }

    /**
     * Method isTriangle
     *
     * @return true - if Triangle.
     */
    public boolean isTriangle(double ab, double ac, double bc) {
        return (ab + ac) > bc && (ab + bc) > ac && (ac + bc) > ab;
    }
}
