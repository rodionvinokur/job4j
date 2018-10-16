package ru.job4j.track;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * ValidateInputTest.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        String ret = System.lineSeparator();
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Введите номер пункта: ", new ArrayList<Integer>(Arrays.asList(new Integer[]{1})));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите целое число: %s", ret)
                )
        );
    }
}
