package ru.job4j.cofe;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.cofe.count.ICount;
import ru.job4j.cofe.count.LeastCount;
import ru.job4j.cofe.input.StubInput;

/**
 * LeastCountTest.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class LeastCountTest {
    @Test
    public void when50and10Then10x4() {
        IMoney[] moneies = {new Money(10), new Money(5), new Money(2), new Money(1)};
        ICount ic = new LeastCount();
        Integer[] result = ic.changes(50, 10, moneies);
        Integer[] expect = {10, 10, 10, 10};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when100and9Then10x9And1() {
        IMoney[] moneies = {new Money(10), new Money(5), new Money(2), new Money(1)};
        ICount ic = new LeastCount();
        Integer[] result = ic.changes(100, 9, moneies);
        Integer[] expect = {10, 10, 10, 10, 10, 10, 10, 10, 10, 1};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when50and25Then10x2And5() {
        IMoney[] moneies = {new Money(10), new Money(5), new Money(2), new Money(1)};
        ICount ic = new LeastCount();
        Integer[] result = ic.changes(50, 25, moneies);
        Integer[] expect = {10, 10, 5};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when50and41Then5And2x2() {
        IMoney[] moneies = {new Money(10), new Money(5), new Money(2), new Money(1)};
        ICount ic = new LeastCount();
        Integer[] result = ic.changes(50, 41, moneies);
        Integer[] expect = {5, 2, 2};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when50and32Then10And5And2And1() {
        IMoney[] moneies = {new Money(10), new Money(5), new Money(2), new Money(1)};
        ICount ic = new LeastCount();
        Integer[] result = ic.changes(50, 32, moneies);
        Integer[] expect = {10, 5, 2, 1};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when1ThenOff() {
        Auto auto = new Auto(new StubInput(new String[]{"1"}));
        String result = auto.start();
        assertEquals("OFF", result);
    }

    @Test
    public void when0001Then10105() {
        Auto auto = new Auto(new StubInput(new String[]{"0", "0", "0", "1"}));
        String result = auto.start();
        assertEquals("[10, 10, 5]", result);
    }

    @Test
    public void when0011Then7x10And5() {
        Auto auto = new Auto(new StubInput(new String[]{"0", "0", "1", "1"}));
        String result = auto.start();
        assertEquals("[10, 10, 10, 10, 10, 10, 10, 5]", result);
    }

    @Test
    public void when03101Then2x10And5() {
        Auto auto = new Auto(new StubInput(new String[]{"0", "3", "1", "0", "1"}));
        String result = auto.start();
        assertEquals("[10, 10, 5]", result);
    }
}
