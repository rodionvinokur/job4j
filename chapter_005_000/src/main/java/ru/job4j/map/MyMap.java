package ru.job4j.map;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by slevi on 04.11.2018.
 */
public class MyMap<K, V> implements IMap<K, V>, Iterable<K> {
    private int bucket = 16;
    private final double loadFactor = 0.75;
    private int capacity = (int) (bucket / loadFactor);
    private Entry<K, V>[] table;
    private int size = 0;

    public MyMap() {
        table = new Entry[bucket];
    }

    public MyMap(int bucket) {
        this.bucket = bucket;
        table = new Entry[bucket];
    }

    @Override
    public boolean insert(K key, V value) {
        if (key == null) {
            return false;
        }
        int index = key.hashCode() % bucket;
        if (table[index] == null || table[index].hash == key.hashCode() && table[index].key.equals(key)) {
            table[index] = new Entry(key, value, table[index] != null ? table[index].next : null);
        } else {
            Entry<K, V> tmp = table[index];
            while (tmp.next != null) {
                if (tmp.next.hash == key.hashCode() && tmp.next.key.equals(key)) {
                    size--;
                    break;
                }
                tmp = tmp.next;
            }
            tmp.next = new Entry(key, value, tmp.next != null ? tmp.next.next : null);
        }
        size++;
        if ((double) size > loadFactor * capacity) {
            expand();
            capacity = (int) ((double) bucket / loadFactor);
        }
        return true;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        int index = key.hashCode() % bucket;
        if (table[index] == null) {
            return null;
        }
        Entry<K, V> entry = table[index];
        for (Entry<K, V> element : entry) {
            if (element.hash == key.hashCode()
                    && element.key.equals(key)) {
                return (V) element.date;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        if (key == null) {
            return false;
        }
        int index = key.hashCode() % bucket;
        if (table[index] == null) {
            return false;
        }
        Entry<K, V> entry = table[index];
        boolean result = false;
        if (entry.hash == key.hashCode() && entry.key.equals(key)) {
            table[index] = table[index].next;
            result = true;
            size--;
        } else {
            while (entry.next != null) {
                if (entry.next.hash == key.hashCode() && entry.next.key.equals(key)) {
                    entry.next = entry.next.next;
                    size--;
                    result = true;
                    break;
                }
                entry = entry.next;
            }
        }

        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int pos = 0;
            Iterator<Entry<K, V>> iter = table[0] == null ? null : table[0].iterator();

            @Override
            public boolean hasNext() {
                for (int i = pos; i < table.length; i++) {
                    if (table[i] != null) {
                        if (pos != i) {
                            pos = i;
                            iter = table[pos].iterator();
                        }
                        if (iter.hasNext()) {
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public K next() {
                    return hasNext() ? iter.next().key : null;
            }
        };
    }

    private class Entry<K, V> implements Iterable<Entry<K, V>> {
        int hash;
        K key;
        V date;
        Entry<K, V> next;
        Entry(K key, V date) {
            this.key = key;
            this.date = date;
            hash = key.hashCode();
        }

        Entry(K key, V date, Entry<K, V> next) {
            this(key, date);
            this.next = next;
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int position = 0;

                private Entry<K, V> getEntry(int position) {
                    Entry<K, V> entry = Entry.this;
                    for (int i = 0; i < position; i++) {
                        entry = entry.next;
                    }
                    return entry;
                }

                @Override
                public boolean hasNext() {
                    return getEntry(position) != null;
                }

                @Override
                public Entry<K, V> next() {
                    if (hasNext()) {
                        position++;
                        return getEntry(position - 1);
                    }
                    return null;
                }
            };
        }
    }

    private void expand() {
        bucket = bucket * 2;
        Entry<K, V>[] tmp = new Entry[bucket];
        this.copyTo(tmp);
        table = tmp;
    }

    private void copyTo(Entry<K, V>[] tmp) {
        for (Entry<K, V> entry : this.table) {
            if (entry != null) {
                for (Entry<K, V> element : entry) {
                    addTo(tmp, element.key, element.date);
                }
            }
        }
    }

    private void addTo(Entry<K, V>[] entry, K key, V date) {
        int index = key.hashCode() % bucket;
        if (entry[index] == null) {
            entry[index] = new Entry(key, date);
        } else {
            Entry<K, V> tmp = entry[index];
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Entry(key, date);
        }
    }
}
