package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * UserConvert
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class UserConvert {
    /**
     * Метод HashMap<Integer, User> process(List<User>)
     *
     * @param list
     * @return
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        for (User userInList : list) {
            hashMap.put(userInList.getId(), userInList);
        }
        return hashMap;
    }
}
