package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * SimpleArrayTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SimpleArrayTest {
    private SimpleArray<Integer> sampl;
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        sampl = new SimpleArray<>(new Integer[]{1, 3, 4, 7});
        it = sampl.iterator();
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenDelete3Then147() {
        sampl.delete(1);
        Integer[] result = sampl.getArray();
        Integer[] expect = {1, 4, 7, null};
        assertArrayEquals(result, expect);
    }

    @Test
    public void whenDelete3AfterAdd5Then1475() {
        sampl.delete(1);
        sampl.add(5);
        Integer[] result = sampl.getArray();
        Integer[] expect = {1, 4, 7, 5};
        assertArrayEquals(result, expect);
    }

    @Test
    public void whenSet3To4Then1474() {
        sampl.set(3, 4);
        Integer[] result = sampl.getArray();
        Integer[] expect = {1, 3, 4, 4};
        assertArrayEquals(result, expect);
    }

    @Test
    public void whenGet3Then7() {
        int result = sampl.get(3);
        int expect = 7;
        assertThat(result, is(expect));
    }
}
