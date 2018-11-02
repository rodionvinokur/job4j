package ru.job4j.list;

/**
 * Created by slevi on 02.11.2018.
 */
public class Queue<E> implements IQueue<E> {
    private IStack<E> stackOne = new Stack<>();
    private IStack<E> stackTwo = new Stack<>();

    @Override
    public E poll() {
        E result = null;
        boolean directionOut = true;
        swap(stackOne, stackTwo);
        result = stackTwo.poll();
        swap(stackTwo, stackOne);
        return result;
    }

    @Override
    public void push(E value) {
        stackOne.push(value);
    }

    private void swap(IStack<E> st1, IStack<E> st2) {
        while (true) {
            E e = st1.poll();
            if (e == null) {
                break;
            }
            st2.push(e);
        }
    }
}
