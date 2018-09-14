package ru.job4j.track;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ValidateInput.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String q, int[] range) {
        int ret = -1;
        do {
            q = super.ask(q);
            try {
                ret = Integer.parseInt(q);
                if (!inRange(ret, range)) {
                    throw new MenuOutException("Введите число из диапазона: " + Arrays.toString(range));
                }
            } catch (NumberFormatException e) {
                q = "Введите целое число: ";
            } catch (MenuOutException e) {
                q = e.getMessage();
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
}
