package ru.job4j.search;


/**
 * Task
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    public int comparePriority(Task o) {
        return Integer.compare(this.getPriority(), o.getPriority());
    }
}

