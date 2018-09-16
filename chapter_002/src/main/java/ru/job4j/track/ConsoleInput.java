package ru.job4j.track;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ConsoleInput.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ConsoleInput implements Input {
    @Override
    public String ask(String q) {
        System.out.println(q);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public int ask(String q, int[] range) throws MenuOutException, NumberFormatException {
        String str = this.ask(q);
        int ret = Integer.parseInt(str);
        if (!inRange(ret, range)) {
            throw new MenuOutException("Введите число из диапазона: " + Arrays.toString(range));
        }
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
