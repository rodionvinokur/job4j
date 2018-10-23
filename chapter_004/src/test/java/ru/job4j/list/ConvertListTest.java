package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConvertListTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ConvertListTest {
    @Test
    public void when2on2ArrayThenList4() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5});
        list.add(new int[]{6, 7, 8, 9});
        list.add(new int[]{10});
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        );
        List<Integer> result = new ConvertList().convert(list);
        assertThat(result, is(expect));
    }
}
