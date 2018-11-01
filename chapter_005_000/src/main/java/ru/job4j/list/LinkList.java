package ru.job4j.list;

/**
 * LinkList
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class LinkList {
    static final int YES = 1;
    static final int NO = 0;
    static final int YET = 2;

    public class Node<T> {
        Node(T value) {
            this.value = value;
        }
        T value;
        Node<T> next;
    }

    public boolean hasCycle(Node startNode) {
        if (step(startNode) == null) {
            return false;
        }
        Node cherepaha = step(startNode);
        Node zayac = step(cherepaha);
        while (cherepaha != zayac && zayac != null) {
            cherepaha = step(cherepaha);
            zayac = step(step(zayac));
        }
        return zayac != null;
    }
    private Node step(Node node) {
        return (node == null)
                ? null
                : (node.next == null)
                    ? null
                    : node.next;
    }
}
