package ru.job4j.cofe.state;

import ru.job4j.cofe.Cofe;
import ru.job4j.cofe.input.Input;

/**
 * MenuState.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class MenuState implements IState {
	private Input inp;
	private String[] greets = {"Выберите тип кофе: "};

	public MenuState(Input inp) {
		this.inp = inp;
	}

	private Cofe[] cofes = {new Cofe("Black", 25), new Cofe("Espresso", 43),
			new Cofe("Lite", 9), new Cofe("Expensive", 125)};

	private String buildMenu() {
		String ret = System.lineSeparator();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cofes.length; i++) {
			sb.append(String.format("(%d): %10s - %d", i, cofes[i].getName(), cofes[i].getPrice())).append(ret);
		}
		return sb.toString();
	}

	public int display() {
		System.out.println(buildMenu());
		return cofes[this.inp.getCode(greets[0], cofes.length)].getPrice();
	}
}
