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

    /**
     * метод hasCycle для поиска цикличности в списках переменной глубины
     * Глубина по условию не известна. Метод в цикле начинает подбирать глубину
     * начиная с 1 (int sizeList = 1)
     * По мере анализа, если не выевляется цикличность или не цикличность глубина увеличивается
     * (sizeList++;)
     * Анализ производиться в процедуре doTest(...), в нее передается стартовый нод и размер списка
     * возврат doTest - NO - нет цикличности, YES - есть, YET - продолжить анализ
     *
     * @param startNode - начальный год списка
     * @return
     */
    public boolean hasCycle(Node startNode) {
        int sizeList = 1;
        while (true) {
            int result = doTest(startNode, sizeList);
            if (result == NO) {
                return false;
            }
            if (result == YES) {
                return true;
            }
            sizeList++;
        }
    }

    /**
     * doTest анализ цикличности списка фиксированного размера
     * (currentNode == null) - на случай если первый элемент списка NULL
     * (currentNode == currentNode.next) - предварительный анализ на цикличность
     * Цикл for (j = sizeList; j > 1; j--) задает смещение оносительно начала списка для
     * выявления замыканий кольцом вглубине списка.
     * for (i = sizeList; i > 1; i--) - элементарная операция для списка фиксированной
     * длины для выявления замыканий типа от A -> . -> . -> A.
     *
     * @param currentNode
     * @param sizeList - начальный размер
     * @return
     */
    int doTest(Node currentNode, int sizeList) {
        int i = sizeList;
        int j = sizeList;
        if (currentNode == null) {
            return NO;
        }
        if (currentNode == currentNode.next) {
            return YES;
        }
        for (j = sizeList; j > 1; j--) {
            Node checkNode = currentNode;
            for (i = sizeList; i > 1; i--) {
                checkNode = checkNode.next;
                if (currentNode == checkNode) {
                    return YES;
                }
                if (checkNode == null) {
                    return NO;
                }
            }
            currentNode = currentNode.next;
        }
        return YET;
    }
}
