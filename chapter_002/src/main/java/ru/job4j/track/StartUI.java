package ru.job4j.track;

/**
 * StartUI.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для отображения всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа для удаления.
     */
    private static final String DEL = "3";
    /**
     * Константа для поиска по ID.
     */
    private static final String FBYID = "4";
    /**
     * Константа для поиска по имени.
     */
    private static final String FBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";


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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите номер пункта меню : ");
            switch (answer.intern()) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showAll();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DEL:
                    this.deleteItem();
                    break;
                case FBYID:
                    this.showItemById();
                    break;
                case FBYNAME:
                    this.showItemByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует поиск по ID.
     */
    private void showItemById() {
        System.out.println("------------- Поиск по номеру заявки ---------------");
        String id = this.input.ask("Введите номер заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            showItem(item);
        }
    }

    /**
     * Метод реализует поиск по имени.
     */
    private void showItemByName() {
        System.out.println("------------- Поиск по имени заявки ----------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            showItem(item);
        }
    }

    /**
     * Метод реализует отображение всех заявок.
     */
    private void showAll() {
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            showItem(item);
        }
    }

    /**
     * Метод реализует отображение одной заявки.
     */
    private void showItem(Item item) {
        if (item != null) {
            System.out.println(item.toString());
        }
    }

    /**
     * Метод реализует удаление одной заявки.
     */
    private void deleteItem() {
        String result = "---------------------- Неудачно ----------------------";
        System.out.println("----------------- Удаление заявки -------------------");
        String id = this.input.ask("Введите номер заявки :");
        if (this.tracker.delete(id)) {
            result = "---------------------- Успешно ----------------------";
        }
        System.out.println(result);

    }

    /**
     * Метод реализует редактирование одной заявки.
     */
    private void editItem() {
        String result = "---------------------- Неудачно ----------------------";
        System.out.println("--------------- Редактирование заявки ----------------");
        String id = this.input.ask("Введите номер заявки :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        if (this.tracker.replace(id, new Item(name, desc))) {
            result = "---------------------- Готово ------------------------";
        }
        System.out.println(result);
    }

    /**
     * Метод реализует отображение меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку.");
        System.out.println("1. Показать все заявки.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по номеру.");
        System.out.println("5. Найти заявку по имени.");
        System.out.println("6. Выход из программы.");
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
