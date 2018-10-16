package ru.job4j.track;

import java.util.List;

/**
 * ValidateInput.
 *
 * @author Rodion V.
 * @version 2.0
 * @since 1.0
 */
public class ValidateInput implements Input {
    private Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public int ask(String q, List<Integer> range) {
        int ret = -1;
        do {
            try {
                ret = this.input.ask(q, range);
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число: ");
            } catch (MenuOutException e) {
                System.out.println(e.getMessage());
                ret = -1;
            }
        } while (ret == -1);
        return ret;
    }

    @Override
    public String ask(String q) {
        return this.input.ask(q);
    }
}
