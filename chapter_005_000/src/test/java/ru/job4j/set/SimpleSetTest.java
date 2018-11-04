package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * SimpleSetTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SimpleSetTest {

    public <T> int countInSimpleSet(SimpleSet<T> t, T element) {
        int count = 0;
        for (T elementInT : t) {
            if (elementInT.equals(element)) {
                count++;
            }
        }
        return count;
    }

    public <T> int count(SimpleSet<T> t) {
        int count = 0;
        for (T elementInT : t) {
            count++;
        }
        return count;
    }

    @Test
    public void whenAddSimpleObjectInEmptyArray() {
        SimpleSet<String> setString = new SimpleSet<>();
        setString.add("Stroka");
        int result = countInSimpleSet(setString, "Stroka");
        assertThat(result, is(1));
    }

    @Test
    public void whenAddTwoEqualObjectThenStoreJustOne() {
        SimpleSet<String> setString = new SimpleSet<>();
        setString.add("one");
        setString.add("two");
        setString.add("one");
        setString.add("three");
        int result = countInSimpleSet(setString, "one");
        assertThat(result, is(1));
        result = countInSimpleSet(setString, "two");
        assertThat(result, is(1));
        result = countInSimpleSet(setString, "three");
        assertThat(result, is(1));
    }

    @Test
    public void whenNotAddObjectCountResult0() {
        SimpleSet<String> setString = new SimpleSet<>();
        int result = count(setString);
        assertThat(result, is(0));
    }

    @Test
    public void whenAddNullObjectCountResult0() {
        SimpleSet<String> setString = new SimpleSet<>();
        setString.add(null);
        int result = count(setString);
        assertThat(result, is(0));
    }
}