package ru.job4j.track;

import java.util.*;
import java.util.stream.Collectors;

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
        if (id != null && item != null) {
            item.setId(id);
            int index = this.items.indexOf(item);
            item.setCreated(findById(id).getCreated());
            if (index != -1) {
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
        try {
            return items
                    .remove(this.items.stream()
                            .filter(x -> x.getId()
                                    .equals(id)).reduce((acc, x) -> acc).get());
        } catch (Exception m) {
            return false;
        }
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
     * как работает map stream java
     *
     * @param name
     * @return
     */
    public List<Item> findByName(String name) {
        return name == null
                ? null
                : items.stream().filter((item) -> item.getName().equals(name)).collect(Collectors.toList());
    }

    /**
     * Метод реализует поиск заявки по id.
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        return id == null
                ? null
                : items.stream()
                    .filter((item) -> item.getId().equals(id)).reduce((acc, x) -> x)
                        .orElse(null);
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
