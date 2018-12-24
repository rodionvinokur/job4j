package ru.job4j.container;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.Container;
import ru.job4j.list.IContainer;

import java.util.Iterator;

/**
 * ThreadContainer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
@ThreadSafe
public class ThreadContainer<E> implements IMContainer<E> {
    @GuardedBy("this")
    private final IContainer<E> container;

    public ThreadContainer(final IContainer<E> container) {
        this.container = container;
    }

    @Override
    public synchronized void add(E value) {
        container.add(value);
    }

    @Override
    public synchronized E get(int index) {
        return container.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return copy(this.container).iterator();
    }

    private synchronized IContainer<E> copy(IContainer<E> container) {
        final IContainer<E> copyContainer = new Container<>(3);
        container.forEach(copyContainer::add);
        return copyContainer;
    }
}
