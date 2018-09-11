package ru.job4j.track;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * StartUI.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
       		MenuTracker menu = new MenuTracker(this.input, this.tracker);
    		List<Integer> range = new ArrayList<>();
    		menu.fillActions();
    		for (int i = 0; i < menu.getActionsLentgh(); i++) {
    			range.add(i);
    		}
    		do {
    			int i = -1;
    			menu.show();
    			Scanner sc  = new Scanner(input.ask("Введите число: " + range));
    			if (sc.hasNextInt()) {
    			    i = sc.nextInt();
    			    if (i > -1 && i < range.size()) {
                        menu.select(i);
                    }
    			}
    		} while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
    
    
}
