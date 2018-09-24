package ru.job4j.cofe;
/**
 * Money.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Money implements IMoney {
	private int denom;
	private String currency;

	public Money(int denom) {
		this(denom, "RUR");
	}

	public Money(int denom, String currency) {
		this.denom = denom;
		this.currency = currency;
	}

	@Override
	public int getDenom() {
		return denom;
	}

	@Override
	public String getCurrency() {
		return currency;
	}
}
