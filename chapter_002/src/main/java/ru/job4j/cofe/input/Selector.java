package ru.job4j.cofe.input;
import java.util.Scanner;

/**
 * Selector.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Selector implements Input {
	@Override
	public int getCode(String q, int range) {
		System.out.println(q);
		Scanner sc = new Scanner(System.in);
		int rc = -1;
		do {
			while (!sc.hasNextInt()) {
				sc.next();
			}
			rc = sc.nextInt();
		} while (!(rc >= 0 && rc < range));
		return rc;
	}

}
