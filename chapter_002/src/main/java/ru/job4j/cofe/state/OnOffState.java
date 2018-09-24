package ru.job4j.cofe.state;

import ru.job4j.cofe.input.Input;

/**
 * OffState.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class OnOffState implements IState {
	private Input inp;
	private String[] greets = {"Выберите действие "};

	public OnOffState(Input inp) {
		this.inp = inp;
	}

	private String[] action = {"Включить", "Выключить"};

	private String buildMenu() {
		String ret = System.lineSeparator();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < action.length; i++) {
			sb.append(String.format("(%d): %s", i, action[i])).append(ret);
		}
		return sb.toString();
	}

	public int display() {
		System.out.println(buildMenu());
		return this.inp.getCode(greets[0], action.length);
	}
}
