package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

/**
 * SimpleSet
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> array = new SimpleArray<T>(10);
    public void add(T t) {
        if (t == null) {
            return;
        }
        boolean elementNotFound = true;
        for (T element : array) {
            if (element.equals(t)) {
                elementNotFound = false;
                break;
            }
        }
        if (elementNotFound) {
            array.add(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
