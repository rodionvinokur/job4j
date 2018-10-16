package ru.job4j.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * PriorityQueue
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * Использует изменненый алгоритм бинарисерч
     *
     * @param task задача
     */
    public void put(Task task) {
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
            return;
        }

        int top = this.tasks.size();
        int down = 1;

        while (true) {
            if (top - down < 4) {
                checkPriority(top, down, task);
                return;
            }

            int middle = top / 2;
            int middleLow = middle / 2;
            int middleHi = (top + middle) / 2;
            int getMiddleLowCmp = this.tasks.get(middleLow - 1).comparePriority(task);

            if (getMiddleLowCmp > 0) {
                top = middleLow;
                continue;
            }

            if (getMiddleLowCmp < 0) {
                down = middleLow;
            } else {
                this.tasks.add(middleLow - 1, task);
                return;
            }
            int getMiddleHiCmp = this.tasks.get(middleHi - 1).comparePriority(task);
            if (getMiddleHiCmp < 0) {
                down = middleHi;
                continue;
            }

            if (getMiddleHiCmp > 0) {
                top = middleHi;
                continue;
            } else {
                this.tasks.add(middleHi - 1, task);
                return;
            }
        }
    }

    public void checkPriority(int top, int down, Task task) {
        if (top == down) {
            if (this.tasks.get(top - 1).comparePriority(task) > 0) {
                this.tasks.add(top - 1, task);
            } else {
                if (top < this.tasks.size()) {
                    this.tasks.add(top, task);
                } else {
                    this.tasks.add(task);
                }
            }
            return;
        }

        if (top != down) {
            if (this.tasks.get(top - 1).comparePriority(task) > 0) {
                checkPriority(top - 1, down, task);
            } else {
                checkPriority(top, down + 1, task);
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}