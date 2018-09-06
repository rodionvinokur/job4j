package ru.job4j.shape;

/**
 * Square
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Square implements Shape {
    /**
     * Method draw square.
     */
    @Override
    public String draw() {
        String ret = System.lineSeparator();
        return new StringBuilder()
                .append(" _______").append(ret)
                .append("|       |").append(ret)
                .append("|       |").append(ret)
                .append("|_______|")
                .toString();
    }
}
