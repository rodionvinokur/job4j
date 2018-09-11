package ru.job4j.track;

import java.util.Arrays;
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
        menu.fillActions();
        do {
            menu.show();
            String inputString = input.ask("Введите число: " + Arrays.toString(menu.range()));
            Scanner sc = new Scanner(inputString);
            if (sc.hasNextInt()) {
                if (menu.inRange(Integer.parseInt(inputString))) {
                    menu.select(Integer.parseInt(inputString));
                }
            }
        } while (!menu.isComplete());
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
