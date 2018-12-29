package ru.job4j.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by slevi on 26.12.2018.
 */
public class Storage {
    private ConcurrentHashMap<Integer, Base> chm = new ConcurrentHashMap<>();

    public boolean add(Base base) {
        return chm.putIfAbsent(base.getId(), base) == null;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "chm=" + chm +
                '}';
    }

    public void update(Base model) {
        int key = model.getId();
        String name = model.getName();
        boolean result = false;
        do {
            final Base current = chm.get(key);
            Integer oldVersion = current.getVersion();
            Integer newVersion = oldVersion + 1;
            Base baseNew = new Base(key, newVersion, name);
            result = chm.replace(key, current, baseNew);
            if (result) {
                System.out.println(oldVersion + " -> " + newVersion);
            }
            /**
             * Без этого блока else должен работать алгоритм lockfree замены значения в мапе
             */
            else {
                throw new OptimisticException("Throw Exception in Thread");
            }
        } while (!result);

    }

    public void delete(Base base) {
        chm.remove(base);
    }
}
