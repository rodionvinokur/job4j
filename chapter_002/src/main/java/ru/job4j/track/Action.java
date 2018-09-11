package ru.job4j.track;

public class Action {
	protected Action(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public int key() {
		return key;
	}

	public String info() {
		return name;
	}

	private int key;
	private String name;
}
