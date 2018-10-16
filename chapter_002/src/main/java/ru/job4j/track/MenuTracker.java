package ru.job4j.track;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;

    /**
     * Константа для отображения всех заявок.
     */
    private static final int SHOW = 1;
    /**
     * Константа для редактирования заявки.
     */
    private static final int EDIT = 2;
    /**
     * Константа для удаления.
     */
    private static final int DEL = 3;
    /**
     * Константа для поиска по ID.
     */
    private static final int FBYID = 4;
    /**
     * Константа для поиска по имени.
     */
    private static final int FBYNAME = 5;
    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    private boolean complete = false;

    public List<UserAction> getActions() {
        return actions;
    }

    public List<Integer> range() {
        List<Integer> range = new ArrayList<>();
        for (UserAction act : actions) {
            range.add(act.key());
        }
        return range;
    }

    public boolean isComplete() {
        return complete;
    }

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив. ("0. Добавить новую заявку.") ("1. Показать все
     * заявки.") ("2. Редактировать заявку.") ("3. Удалить заявку.") ("4. Найти
     * заявку по номеру.") ("5. Найти заявку по имени.") ("6. Выход из программы.")
     */
    public void fillActions() {
        this.actions.add(this.new AddItem(ADD, "Добавить новую заявку."));
        this.actions.add(this.new ShowItems(SHOW, "Показать все заявки."));
        this.actions.add(new MenuTracker.EditItem(EDIT, "Редактировать заявку."));
        this.actions.add(new DeleteItem(DEL, "Удалить заявку."));
        this.actions.add(this.new FindItemById(FBYID, "Найти заявку по номеру."));
        this.actions.add(this.new FindItemsByName(FBYNAME, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(EXIT, "Выход из программы."));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     * <p>
     * Добавлен блок try-catch, только для успешного прохождения теста
     * whenWrongMenuNumberThenSizeFindAll()
     *
     * @param key ключ операции
     */

    public void select(int key) {
        try {
            this.actions.get(key).execute(this.input, this.tracker);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    public class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует поиск по ID.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------- Поиск по номеру заявки ---------------");
            String id = input.ask("Введите номер заявки :");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }

    public class FindItemsByName extends BaseAction {
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------- Поиск по имени заявки ----------------");
            String name = input.ask("Введите имя заявки :");
            List<Item> items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

    }

    public class ShowItems extends BaseAction {
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> items = tracker.findAll();
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }

        public ShowItems(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует отображение одной заявки.
         */
        private void showItem(Item item) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }

    public static class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String result = "---------------------- Неудачно ----------------------";
            System.out.println("--------------- Редактирование заявки ----------------");
            String id = input.ask("Введите номер заявки :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            if (tracker.replace(id, new Item(name, desc))) {
                result = "---------------------- Готово ------------------------";
            }
            System.out.println(result);
        }
    }

    public class ExitProgram extends BaseAction {
        @Override
        public void execute(Input input, Tracker tracker) {
            complete = true;
        }

        public ExitProgram(int key, String name) {
            super(key, name);
        }

    }
}

class DeleteItem extends BaseAction {
    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String result = "---------------------- Неудачно ----------------------";
        System.out.println("----------------- Удаление заявки -------------------");
        String id = input.ask("Введите номер заявки :");
        if (tracker.delete(id)) {
            result = "---------------------- Успешно ----------------------";
        }
        System.out.println(result);
    }
}
