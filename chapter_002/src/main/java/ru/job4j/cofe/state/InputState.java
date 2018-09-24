package ru.job4j.cofe.state;

import ru.job4j.cofe.Money;
import ru.job4j.cofe.input.Input;
/**
 * InputState.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class InputState implements IState {

	private Input inp;
	private String[] greets = {"Выберите купюры: ", "Введите количество купюр: "};

	public InputState(Input inp) {
		this.inp = inp;
	}

	private Money[] money = {new Money(50), new Money(100)};

	private String buildMenu() {
		String ret = System.lineSeparator();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < money.length; i++) {
			sb.append(String.format("(%d): %d %s", i, money[i].getDenom(), money[i].getCurrency())).append(ret);
		}
		return sb.toString();
	}

	@Override
	public int display() {
		System.out.println(buildMenu());
		return money[this.inp.getCode(greets[0], money.length)].getDenom();
	}

}
