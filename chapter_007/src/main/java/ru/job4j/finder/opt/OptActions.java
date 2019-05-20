package ru.job4j.finder.opt;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * Interface OptActions
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

public interface OptActions<T> {
    T apply();

    BinaryOperator<String> SPLITTER = (str, letter) ->
            Arrays.stream(str.split("-"))
                    .filter(x -> x.startsWith(letter))
                    .map(x -> x.substring(letter.length()).trim())
                    .findFirst()
                    .orElse("");
}
