package ru.job4j.track;

import java.util.*;

/**
 * Tracker.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    public Tracker() {
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        if (item != null) {
            long time = new Date().getTime();
            item.setCreated(time);
            String id = this.generateId(time >> items.size());
            item.setId(id);
            this.items.add(item);
        }
        return item;
    }

    /**
     * Метод реализующий замену заявки в хранилище.
     *
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        if (id != null) {
            int index = this.indexOf(id);
            if (index != -1) {
                item.setId(id);
                item.setCreated(findById(id).getCreated());
                this.items.set(index, item);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод реализующий удаление заявки из хранилища.
     *
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        if (id != null) {
            int index = this.indexOf(id);
            if (index != -1) {
                items.remove(index);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод возвращает все зявки
     *
     * @return
     */
    public List<Item> findAll() {
        return items;
    }

    public List<Item> getItems() {
        return items;
    }


    /**
     * Метод реализует поиск заявки по имени.
     *
     * @param name
     * @return
     */
    public List<Item> findByName(String name) {
        List<Item> tmp = new ArrayList<>();
        if (name != null) {
            int position = 0;
            for (int index = 0; index < items.size(); index++) {
                if (this.items.get(index).getName().equals(name)) {
                    tmp.add(this.items.get(index));
                }
            }
        }
        return tmp;
    }

    /**
     * Метод реализует поиск заявки по id.
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item item = null;
        if (id != null) {
            int index = this.indexOf(id);
            if (index != -1) {
                item = this.items.get(index);
            }
        }
        return item;
    }

    /**
     * Метод возвращает индекс заявки в массиве.
     *
     * @param id
     * @return
     */
    private int indexOf(String id) {
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId(long time) {
        Random random = new Random(time);
        return Long.toString(Math.abs(random.nextLong()));
    }
}
