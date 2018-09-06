package ru.job4j.shape;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class PaintTest {
    /**
     * Method whenDrawSquare.
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.setKind(new Square());
        paint.draw();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(" _______").append(System.lineSeparator())
                                .append("|       |").append(System.lineSeparator())
                                .append("|       |").append(System.lineSeparator())
                                .append("|_______|").append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }
    /**
     * Method whenDrawTriangle.
     */
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.setKind(new Triangle());
        paint.draw();
        String ret = System.lineSeparator();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  /\\").append(ret)
                                .append(" /  \\").append(ret)
                                .append("/____\\").append(ret)
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}