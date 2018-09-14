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
        System.out.println(q);
        Scanner sc = new Scanner(System.in);
        int ret = -1;
        do {
            try {
                if (!sc.hasNextInt()) {
                   sc.nextLine();
                   throw new MenuOutException("Введите целое число: ");
                }
                ret = Integer.parseInt(sc.nextLine());
                if (!inRange(ret, range)) {
                    throw new MenuOutException("Введите число из диапазона: " + Arrays.toString(range));
                }
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
}
