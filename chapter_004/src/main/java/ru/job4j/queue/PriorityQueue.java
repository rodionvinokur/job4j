package ru.job4j.queue;

import java.util.LinkedList;
import java.util.stream.Collectors;

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
     *
     * @param task задача
     */
    public void put(Task task) {
        this.tasks.add(task);
        this.tasks = this.tasks.stream()
                .sorted().collect(Collectors.toCollection(LinkedList::new));
    }

    public Task take() {
        return this.tasks.poll();
    }
}