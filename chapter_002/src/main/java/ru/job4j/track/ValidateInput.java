package ru.job4j.track;

import java.util.Arrays;

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
    public int ask(String q, int[] range) {
        int ret = -1;
        do {
            String str = this.ask(q);
            try {
                ret = Integer.parseInt(str);
                if (!inRange(ret, range)) {
                    throw new MenuOutException("Введите число из диапазона: " + Arrays.toString(range));
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число: ");
            } catch (MenuOutException e) {
                System.out.println(e.getMessage());
                ret = -1;
            }
        } while (ret == -1);
        return ret;
    }

    public boolean inRange(int act, int[] range) {
        boolean result = false;
        for (int i : range) {
            if (act == i) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public String ask(String q) {
        return this.input.ask(q);
    }
}
