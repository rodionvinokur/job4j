package ru.job4j.cofe;
import java.util.Arrays;

import ru.job4j.cofe.count.*;
import ru.job4j.cofe.input.*;
import ru.job4j.cofe.state.*;

/**
 * Auto.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Auto {
	public static final int ON = 0;
	public static final int MENU = 0;
	public static final int INPUT = 1;
	public static final int ONOFF = 2;
	private Input inp;
	public Auto(Input inp) {
		this.inp = inp;
		this.state[0] = new MenuState(this.inp);
		this.state[1] = new InputState(this.inp);
		this.state[2] = new OnOffState(this.inp);
		this.cnt = new LeastCount();
	}

	public Auto() {
		this(new Selector());
	}

	private IState[] state = new IState[3];
	private ICount cnt;
	public void setMoneies(Money[] moneies) {
		this.moneies = moneies;
	}
	public void setCnt(ICount cnt) {
		this.cnt = cnt;
	}

	private IMoney[] moneies = {new Money(10), new Money(5), new Money(2), new Money(1)};

	public Integer[] changes(int amount, int price) {
		return cnt.changes(amount, price, moneies);
	}

	public String start() {
		String result = "OFF";
		while (state[ONOFF].display() == ON) {
			int amount = 0;
			int price = 0;
			price = state[MENU].display();
			do {
				if (amount > 0) {
					System.out.println("Недостаточно денег. Доложите еще.");
					System.out.println();
				}
				amount += state[INPUT].display();
			} while (amount < price);
			try {
				result = Arrays.toString(changes(amount, price));
			} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
				result = "Невозможно рассчитать сдачу";
			}
			System.out.println("Сдача: " + (amount - price) + " " + moneies[0].getCurrency() + ": " + result
					+ System.lineSeparator());
		}
		return result;
	}
}
