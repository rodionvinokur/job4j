package ru.job4j.condition;

/**
 * Point
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Point {
    /**
     *  Axis "x".
     */
    private double x;
    /**
     * Axis "y".
     */
    private double y;

    /**
     * Class constructor
     * @param x, y - Point axes.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter x.
     * @return x axis.
     */
    public double getX() {
        return x;
    }

    /**
     * Getter y.
     * @return y axis.
     */
    public double getY() {
        return y;
    }

    /**
     * Distance beetwen Points.
     * @param  p - Points objects
     * @return distance as double.
     */
    public double distanceTo(Point p) {
        return Math.sqrt(
          Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2)
        );
    }
    /**
     * Method main.
     * @param args from cmd.
     */
    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(3, 0);
        System.out.println(p1.distanceTo(p2));
    }
}
