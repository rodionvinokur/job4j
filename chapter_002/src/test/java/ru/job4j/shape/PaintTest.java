package ru.job4j.shape;

import org.junit.After;
import org.junit.Before;
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
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setOut() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOut() {
        System.setOut(stdout);
    }
    /**
     * Method whenDrawSquare.
     */
    @Test
    public void whenDrawSquare() {
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
    }
    /**
     * Method whenDrawTriangle.
     */
    @Test
    public void whenDrawTriangle() {
        Paint paint = new Paint();
        paint.setKind(new Triangle());
        paint.draw();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  /\\").append(System.lineSeparator())
                                .append(" /  \\").append(System.lineSeparator())
                                .append("/____\\").append(System.lineSeparator())
                                .toString()
                )
        );
    }
}