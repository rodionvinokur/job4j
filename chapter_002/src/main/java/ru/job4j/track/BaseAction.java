package ru.job4j.track;

public abstract class BaseAction implements UserAction {
	protected BaseAction(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public int key() {
		return key;
	}

	public String info() {
		return String.format("%d. %s", this.key, this.name);
	}

	private int key;
	private String name;
}
