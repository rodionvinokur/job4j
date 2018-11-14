package ru.job4j.map;

/**
 * Created by slevi on 04.11.2018.
 */
public interface IMap<K, V> {
    boolean insert(K key, V value);

    V get(K key);

    boolean delete(K key);
}
