package ru.job4j.shape;

/**
 * Paint for context
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Paint {
    public void setKind(Shape shape) {
        this.shape = shape;
    }

    /**
     * Method draw context.
     */
    public void draw() {
        System.out.println(shape.draw());
    }
    private Shape shape;
}
