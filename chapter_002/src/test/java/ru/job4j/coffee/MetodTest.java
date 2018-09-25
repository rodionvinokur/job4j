package ru.job4j.coffee;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * MetodTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

public class MetodTest {
    @Test
    public void when50and10Then10x4() {
        Metod metod = new Metod();
        int[] result = metod.changes(50, 10);
        int[] expect = {10, 10, 10, 10};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when100and9Then10x9And1() {
        Metod metod = new Metod();
        int[] result = metod.changes(100, 9);
        int[] expect = {10, 10, 10, 10, 10, 10, 10, 10, 10, 1};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when50and25Then10x2And5() {
        Metod metod = new Metod();
        int[] result = metod.changes(50, 25);
        int[] expect = {10, 10, 5};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when50and41Then5And2x2() {
        Metod metod = new Metod();
        int[] result = metod.changes(50, 41);
        int[] expect = {5, 2, 2};
        assertArrayEquals(result, expect);
    }

    @Test
    public void when50and32Then10And5And2And1() {
        Metod metod = new Metod();
        int[] result = metod.changes(50, 32);
        int[] expect = {10, 5, 2, 1};
        assertArrayEquals(result, expect);
    }
 }
