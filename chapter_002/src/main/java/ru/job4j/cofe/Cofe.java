package ru.job4j.cofe;

/**
 * Cofe.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Cofe {
	private String name;
	private int price;

	public Cofe(String name, int price) {
		this.price = price;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
