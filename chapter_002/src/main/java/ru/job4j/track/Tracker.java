package ru.job4j.track;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

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
    private Item[] items = null;
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public Item getItem(int position) {
        return items[position];
    }

    public Tracker(int cnt) {
        items = new Item[cnt < 5 ? 5 : cnt];
    }

    public Tracker() {
        items = new Item[100];
    }

    /**

     * Указатель ячейки для новой заявки.
     */


    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        if (item != null && position != items.length) {
            item.setId(this.generateId());
            this.items[this.position++] = item;
        }
        return item;
    }

    /**
     * Метод реализующий замену заявки в хранилище.
     *
     * @param id
     * @param item
     */
    public void replace(String id, Item item) {
        if (id != null) {
            int index = this.indexOf(id);
            if (index != -1) {
                item.setId(this.generateId());
                this.items[index] = item;
            }
        }
    }

    /**
     *  Метод реализующий удаление заявки из хранилища.
     *
     * @param id
     */
    public void delete(String id) {
        if (id != null) {
            int index = this.indexOf(id);
            if (index != -1) {
                if (index + 1 != this.position) {
                    System.arraycopy(this.items,index + 1,
                            this.items, index, this.position - index + 1);
                }
                --position;
            }
        }
    }

    /**
     * Метод возвращает все зявки
     *
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Метод реализует поиск заявки по имени.
     *
     * @param name
     * @return
     */
    public Item[] findByName(String name) {
        Item[] tmp = new Item[0];
        if (name != null) {
            tmp = new Item[this.position];
            int position = 0;
            for (int index = 0; index < this.position; index++) {
                if (this.items[index].getName().equals(name)) {
                    tmp[position++] = this.items[index];
                }
            }
            tmp = Arrays.copyOf(tmp, position);
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
                item = this.items[index];
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
    private int indexOf(@NotNull String id) {
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
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
    private String generateId() {
        Random random = new Random(new Date().getTime());
        return Long.toString(Math.abs(random.nextLong()));
    }
}
