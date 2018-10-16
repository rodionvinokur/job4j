package ru.job4j.track;

import java.util.List;

/**
 * Input.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface Input {
    String ask(String q);
    int ask(String question, List<Integer> range);
}
