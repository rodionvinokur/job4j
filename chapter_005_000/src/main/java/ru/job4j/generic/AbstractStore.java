package ru.job4j.generic;

import java.util.Iterator;

/**
 * AbstractStore
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class AbstractStore<T extends Base> implements Store<T> {
    protected SimpleArray<T> simpleArray;

    private int indexOf(String id) {
        Iterator<T> iter = simpleArray.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            T t = iter.next();
            if (t == null) {
                break;
            }
            if (t.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        return indexOf(id) == -1 ? false : this.simpleArray.set(index, model);
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        return indexOf(id) == -1 ? false : this.simpleArray.delete(index);
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return indexOf(id) == -1 ? null : this.simpleArray.get(index);
    }
}
