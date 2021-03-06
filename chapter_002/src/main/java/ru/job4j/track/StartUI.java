package ru.job4j.track;

import java.util.Arrays;
import java.util.function.Consumer;

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
        Consumer<MenuTracker> show = MenuTracker::show;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            show.accept(menu);
            menu.select(input.ask("Введите номер пункта: " + menu.range(), menu.range()));
        } while (!menu.isComplete());
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }


}
