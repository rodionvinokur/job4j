package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * PhoneDictionary
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        return persons.stream().filter(person -> person.getAddress().contains(key)
                        || person.getName().contains(key)
                        || person.getPhone().contains(key)
                        || person.getSurname().contains(key)
        ).collect(Collectors.toList());
    }
}
