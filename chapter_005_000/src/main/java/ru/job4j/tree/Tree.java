package ru.job4j.tree;

import ru.job4j.generic.SimpleArray;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Tree
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E value) {
        root = new Node<E>(value);
    }

    private int state;

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNodeOptional = findBy(parent);
        if (parentNodeOptional.isPresent()) {
            Node<E> parentNode = parentNodeOptional.get();
            List<Node<E>> listNode = parentNode.leaves();
            if (!listNode.contains(new Node<E>(child))) {
                listNode.add(new Node<E>(child));
                state++;
                result = true;
            }

        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> currentNode = data.poll();
            if (currentNode.eqValue(value)) {
                result = Optional.of(currentNode);
                break;
            }
            for (Node<E> child : currentNode.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        List<E> list = new LinkedList<>();
        list.add(root.getValue());
        addToList(root, list);
        Iterator<E> iter = list.iterator();

        return new Iterator<E>() {
            int mod = state;

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public E next() {
                if (mod != state) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iter.next();
            }
        };
    }

    private void addToList(Node<E> node, List<E> list) {
        if (node != null) {
            List<Node<E>> tmp = node.leaves();
            list.addAll(tmp.stream().map(Node::getValue).collect(Collectors.toList()));
            for (Node<E> elem : tmp) {
                addToList(elem, list);
            }
        }
    }
}
