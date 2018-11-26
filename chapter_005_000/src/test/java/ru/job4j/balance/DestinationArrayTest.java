package ru.job4j.balance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * DestinationArrayTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class DestinationArrayTest {
    DestinationArray left;
    DestinationArray right;
    Split split;

    public void test(Integer[] source, Integer[] arr1, Integer[] arr2) {
        DestinationArray left = new DestinationArray(source);
        DestinationArray right = new DestinationArray(source);
        split.splitToSameArray(source, left, right);
        assertArrayEquals(arr1, left.getArray());
        assertArrayEquals(arr2, right.getArray());
    }

    @Before
    public void set() {
        split = new Split();
    }

    @Test
    public void testWhenPossibleEqualsArray() {
        Integer[] source = {10, 20, 30, 5, 40, 50, 40, 15};
        test(source, new Integer[]{40, 40, 15, 10}, new Integer[]{50, 30, 20, 5});
    }

    @Test
    public void testWhenSubstructionSameMinElement() {
        Integer[] source = {1, 3, 7, 8, 10};
        test(source, new Integer[]{8, 7}, new Integer[]{10, 3, 1});
    }

    @Test
    public void testWhenPossibleInnerCycle() {
        Integer[] source = {1, 3, 7, 8, 10, 115, 118, 122};
        test(source,  new Integer[]{118, 115}, new Integer[]{122, 10, 8, 7, 3, 1});
    }
}