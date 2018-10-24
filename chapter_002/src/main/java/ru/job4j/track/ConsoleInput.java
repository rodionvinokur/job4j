package ru.job4j.track;
import java.util.Arrays;
import java.util.List;
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
    public int ask(String q, List<Integer> range) throws MenuOutException, NumberFormatException {
        String str = this.ask(q);
        int ret = Integer.parseInt(str);
        if (!inRange(ret, range)) {
            throw new MenuOutException("Введите число из диапазона: " + range);
        }
        return ret;
    }

    public boolean inRange(int act, List<Integer> range) {
        return range.stream().anyMatch(x -> act == x);
    }
}
