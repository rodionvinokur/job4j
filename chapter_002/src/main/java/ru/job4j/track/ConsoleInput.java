package ru.job4j.track;
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
    public int ask(String q, int[] range) {
        return 0;//new ValidateInput(this).ask(q, range);
    }
}
