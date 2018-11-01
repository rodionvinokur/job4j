package ru.job4j.list;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * IContainerTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class IContainerTest {
    private IContainer<Integer> icArray;
    private IContainer<Integer> icLink;

    @Before
    public void setUp() {
        icArray = new Container<>(5);
        icLink = new LinkedContainer<>();
    }

    private void testBeforeLimitCapacity(IContainer<Integer> ic) {
        ic.add(1);
        ic.add(2);
        ic.add(3);
        ic.add(4);
        ic.add(5);
        assertThat(ic.get(4), is(5));
    }

    private void testOverLimitCapacity(IContainer<Integer> ic) {
        ic.add(1);
        ic.add(2);
        ic.add(3);
        ic.add(4);
        ic.add(5);
        ic.add(6);
        ic.add(7);
        assertThat(ic.get(6), is(7));
    }

    private void hasNextNextSequentialInvocation(IContainer<Integer> ic) {
        ic.add(1);
        ic.add(2);
        ic.add(3);
        ic.add(4);
        ic.add(5);
        Iterator it = ic.iterator();
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(5));
        assertThat(it.hasNext(), Matchers.is(false));
    }

    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation(IContainer<Integer> ic) {
        ic.add(1);
        ic.add(2);
        ic.add(3);
        ic.add(4);
        ic.add(5);
        Iterator it = ic.iterator();
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.next(), Matchers.is(5));
    }

    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder(IContainer<Integer> ic) {
        ic.add(1);
        ic.add(2);
        ic.add(3);
        ic.add(4);
        ic.add(5);
        Iterator it = ic.iterator();
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.next(), Matchers.is(5));
    }

    public void hasNextShouldReturnFalseInCaseOfEmptyIterators(IContainer<Integer> ic) {
        Iterator it = ic.iterator();
        assertThat(it.hasNext(), Matchers.is(false));
    }


    public void invocationOfNextMethodShouldThrowNoSuchElementException(IContainer<Integer> ic) throws NoSuchElementException {
        ic.add(1);
        ic.add(2);
        ic.add(3);
        ic.add(4);
        ic.add(5);
        Iterator it = ic.iterator();
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.next(), Matchers.is(5));
        it.next();
    }

    public void invocationOfNextMethodShouldThrowIfListChanged(IContainer<Integer> ic) throws ConcurrentModificationException {
        Iterator it = ic.iterator();
        ic.add(1);
        ic.add(2);
        ic.add(3);
        ic.add(4);
        ic.add(5);
        ic.add(6);
        it.next();
    }

    @Test
    public void testAddAndGetContainerWhenBeforeLimitCapacityArray() {
        testBeforeLimitCapacity(icArray);
    }

    @Test
    public void testAddAndGetContainerWhenOverLimitCapacityArray() {
        testOverLimitCapacity(icArray);
    }

    @Test
    public void hasNextNextSequentialInvocationArray() {
        hasNextNextSequentialInvocation(icArray);
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocationArray() {
        testsThatNextMethodDoesntDependsOnPriorHasNextInvocation(icArray);
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrderArray() {
        sequentialHasNextInvocationDoesntAffectRetrievalOrder(icArray);
    }

    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIteratorsArray() {
        hasNextShouldReturnFalseInCaseOfEmptyIterators(icArray);
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementExceptionArray() {
        invocationOfNextMethodShouldThrowNoSuchElementException(icArray);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void invocationOfNextMethodShouldThrowIfListChangedArray() {
        invocationOfNextMethodShouldThrowIfListChanged(icArray);
    }

    //-----------------------------------------------------------------

    @Test
    public void testAddAndGetContainerWhenBeforeLimitCapacityLink() {
        testBeforeLimitCapacity(icLink);
    }

    @Test
    public void testAddAndGetContainerWhenOverLimitCapacityLink() {
        testOverLimitCapacity(icLink);
    }

    @Test
    public void hasNextNextSequentialInvocationLink() {
        hasNextNextSequentialInvocation(icLink);
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocationLink() {
        testsThatNextMethodDoesntDependsOnPriorHasNextInvocation(icLink);
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrderLink() {
        sequentialHasNextInvocationDoesntAffectRetrievalOrder(icLink);
    }

    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIteratorsLink() {
        hasNextShouldReturnFalseInCaseOfEmptyIterators(icLink);
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementExceptionLink() {
        invocationOfNextMethodShouldThrowNoSuchElementException(icLink);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void invocationOfNextMethodShouldThrowIfListChangedLink() {
        invocationOfNextMethodShouldThrowIfListChanged(icLink);
    }
}