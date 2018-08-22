package ru.job4j.condition;

/**
 * Triangle
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

        if (a.getX() == b.getX() && b.getX() == c.getX()
                || a.getY() == b.getY() && b.getY() == c.getY()) {
            return false;
        }

        if (a.getX() != b.getX() && a.getX() != c.getX() && c.getX() != b.getX()
                && a.getY() != b.getY() && a.getY() != c.getY() && c.getY() != b.getY()) {

            double sub1 = (a.getX() - b.getX()) / (a.getY() - b.getY());
            double sub2 = (b.getX() - c.getX()) / (b.getY() - c.getY());
            double sub3 = (a.getX() - c.getX()) / (a.getY() - c.getY());

            if (sub1 == sub2 && sub1 == sub3 && sub2 == sub3) {
                return false;
            }
        }
        return true;
    }
}
