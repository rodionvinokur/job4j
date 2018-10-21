package ru.job4j.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Matematika
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Matematika {
    private List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> ld = new ArrayList<>();
        for (Integer i = start; i <= end; i++) {
            ld.add(func.apply(i.doubleValue()));
        }
        return ld;
    }

    public List<Double> linear(int start, int end) {
        return diapason(start, end, (x) -> 2 * x + 1);
    }

    public List<Double> quadratic(int start, int end) {
        return diapason(start, end, (x) -> 2 * x * x + x * 3 + 1);
    }

    public List<Double> logarithmic(int start, int end) {
        return diapason(start, end, Math::log10);
    }
}
