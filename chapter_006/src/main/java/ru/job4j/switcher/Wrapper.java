package ru.job4j.switcher;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Wrapper
 * Класс обертка для строки.
 *
 * @author Rodion V.
 * @version 2.0
 * @since 1.0
 */
public class Wrapper {
    private AtomicReference<String> obj = new AtomicReference<>("");

    public String getString() {
        return obj.get();
    }

    public void addObj(String s, boolean test) {
        String stringOld;
        String stringNew;
        do {
            stringOld = obj.get();
            stringNew = stringOld + s;
        } while (!obj.compareAndSet(stringOld, stringNew));
    }
}
