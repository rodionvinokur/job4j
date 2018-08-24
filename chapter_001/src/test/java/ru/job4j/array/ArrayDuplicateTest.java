package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test for ArrayDuplicateTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ArrayDuplicateTest {
    /**
     * Method test remove duplicate in String[].
     */
    @Test
    public void whenDuplicatesThenRemoveDuplicateElseDoNothing() {
        ArrayDuplicate m = new ArrayDuplicate();
        String[] input = {"Roma", "Misha", "Kolya", "Olya", "Misha", "Roma"};
        String[] result = m.remove(input);
        String[] expect = {"Roma", "Misha", "Kolya", "Olya"};
        assertThat(result, is(expect));

        input = new String[]{"Roma", "Roma", "Roma", "Roma", "Roma", "Roma"};
        result = m.remove(input);
        expect = new String[]{"Roma"};
        assertThat(result, is(expect));

        input = new String[]{"Roma", "Sasha"};
        result = m.remove(input);
        expect = new String[]{"Roma", "Sasha"};
        assertThat(result, is(expect));
    }

}
