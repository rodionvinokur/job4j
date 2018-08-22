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
        if (!isTriangle()) {
            return -1;
        }

        double pHalf = (a.distanceTo(b) + a.distanceTo(c) + b.distanceTo(c)) / 2;

        return Math.sqrt(pHalf * (pHalf - a.distanceTo(b)) * (pHalf - b.distanceTo(c)) * (pHalf - a.distanceTo(c)));
    }

    /**
     * Method isTriangle
     *
     * @return true - if Triangle.
     */
    public boolean isTriangle() {

        return (a.distanceTo(b) + a.distanceTo(c)) > b.distanceTo(c)
                && (a.distanceTo(b) + b.distanceTo(c)) > a.distanceTo(c)
                && (a.distanceTo(c) + b.distanceTo(c)) > a.distanceTo(b);




    }
}
