package ru.job4j.part;

import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * DictionaryTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class DictionaryTest {
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
    public void testDictionarySort() {
        String ret = System.lineSeparator();
        Dictionary dictionary = new Dictionary();
        dictionary.add(new Department("K1\\SK1\\SSK1"));
        dictionary.add(new Department("K1\\SK1\\SSK2"));
        dictionary.add(new Department("K2\\SK1\\SSK2"));
        dictionary.add(new Department("K2\\SK1\\SSK1"));
        dictionary.add(new Department("K2\\SK2\\SSK2"));
        dictionary.sort().print();
        StringBuilder sb = new StringBuilder();
        sb.append("K1").append(ret)
                .append("K1\\SK1").append(ret)
                .append("K1\\SK1\\SSK1").append(ret)
                .append("K1\\SK1\\SSK2").append(ret)
                .append("K2").append(ret)
                .append("K2\\SK1").append(ret)
                .append("K2\\SK1\\SSK1").append(ret)
                .append("K2\\SK1\\SSK2").append(ret)
                .append("K2\\SK2").append(ret)
                .append("K2\\SK2\\SSK2").append(ret);
        ret = sb.toString();
        assertThat(this.mem.toString(), is(ret));
    }

    @Test
    public void testDictionaryReverse() {
        String ret = System.lineSeparator();
        Dictionary dictionary = new Dictionary();
        dictionary.add(new Department("K1\\SK1\\SSK1"));
        dictionary.add(new Department("K1\\SK1\\SSK2"));
        dictionary.add(new Department("K2\\SK1\\SSK2"));
        dictionary.add(new Department("K2\\SK1\\SSK1"));
        dictionary.add(new Department("K2\\SK2\\SSK2"));
        dictionary.reverse().print();
        StringBuilder sb = new StringBuilder();
        sb.append("K2").append(ret)
                .append("K2\\SK2").append(ret)
                .append("K2\\SK2\\SSK2").append(ret)
                .append("K2\\SK1").append(ret)
                .append("K2\\SK1\\SSK2").append(ret)
                .append("K2\\SK1\\SSK1").append(ret)
                .append("K1").append(ret)
                .append("K1\\SK1").append(ret)
                .append("K1\\SK1\\SSK2").append(ret)
                .append("K1\\SK1\\SSK1").append(ret);
        ret = sb.toString();
        assertThat(this.mem.toString(), is(ret));
    }
}
