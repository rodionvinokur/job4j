package ru.job4j.shape;

/**
 * Triangle
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Triangle implements Shape {
    /**
     * Method draw triangle.
     */
    @Override
    public String draw() {
        String ret = System.lineSeparator();
        return new StringBuilder()
                .append("  /\\").append(ret)
                .append(" /  \\").append(ret)
                .append("/____\\")
                .toString();
    }
}
