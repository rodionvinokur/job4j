package ru.job4j.iter;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * IteratorIntTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class IteratorIntTest {
    private Iterator<Integer> it0;
    private Iterator<Integer> it1;
    private Iterator<Integer> it2;
    private IteratorIter<Integer> iter;
    private Iterator<Integer> ii0;
    @Before
    public void setUp() {
        it0 = new IteratorInt(new Integer[]{4, 2, 0, 4, 6, 4, 9});
        it1 = new IteratorInt(new Integer[]{0, 9, 8, 7, 5});
        it2 = new IteratorInt(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4});
        iter = new IteratorIter(new Iterator[]{it0, it1, it2});
        ii0 = iter.convert(iter);
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(ii0.next(), is(4));
        assertThat(ii0.next(), is(2));
        assertThat(ii0.next(), is(0));
        assertThat(ii0.next(), is(4));
        assertThat(ii0.next(), is(6));
        assertThat(ii0.next(), is(4));
        assertThat(ii0.next(), is(9));
        assertThat(ii0.next(), is(0));
        assertThat(ii0.next(), is(9));
        assertThat(ii0.next(), is(8));
        assertThat(ii0.next(), is(7));
        assertThat(ii0.next(), is(5));
        assertThat(ii0.next(), is(1));
        assertThat(ii0.next(), is(3));
        assertThat(ii0.next(), is(5));
        assertThat(ii0.next(), is(6));
        assertThat(ii0.next(), is(7));
        assertThat(ii0.next(), is(0));
        assertThat(ii0.next(), is(9));
        assertThat(ii0.next(), is(8));
        assertThat(ii0.next(), is(4));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(4));
        assertThat(ii0.next(), is(2));
        assertThat(ii0.next(), is(0));
        assertThat(ii0.next(), is(4));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(ii0.next(), is(4));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(2));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(0));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(4));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(6));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(4));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(9));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(0));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(9));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(8));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(7));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(5));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(1));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(3));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(5));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(6));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(7));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(0));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(9));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(8));
        assertThat(ii0.hasNext(), is(true));
        assertThat(ii0.next(), is(4));
        assertThat(ii0.hasNext(), is(false));
    }
}
