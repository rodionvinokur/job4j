package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * SortUserTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SortUserTest {
    @Test
    public void sortInTreeSet() {
        SortUser su = new SortUser();
        User usr1 = new User("Maksim", 13);
        User usr2 = new User("Nikita", 16);
        User usr3 = new User("Vova", 6);
        User usr4 = new User("Misha", 9);
        User usr5 = new User("Ded", 100);
        User usr6 = new User("Baba", 99);
        User usr7 = new User("Mama", 60);
        User usr8 = new User("Papa", 65);
        List<User> lUser = new ArrayList<>(Arrays.asList(
                new User[]{usr1, usr2, usr3, usr4, usr5, usr6, usr7, usr8}
        ));
        User[] usrArray = new User[8];
        su.sort(lUser).toArray(usrArray);
        assertThat(Arrays.toString(usrArray),
                is("[[6], [9], [13], [16], [60], [65], [99], [100]]"));
    }

    @Test
    public void sortListByNameLength() {
        List<User> lUser = new ArrayList<>();
        lUser.add(new User("Barton J.", 56));
        lUser.add(new User("Boris M.", 60));
        lUser.add(new User("Lomonosov M.", 250));
        SortUser su = new SortUser();
        User[] usrArray = new User[3];
        su.sortNameLength(lUser).toArray(usrArray);
        assertThat(Arrays.toString(usrArray),
                is("[[60], [56], [250]]"));
    }

    @Test
    public void sortListByAll() {
        List<User> lUser = new ArrayList<>();
        lUser.add(new User("Сергей", 25));
        lUser.add(new User("Иван", 30));
        lUser.add(new User("Сергей", 20));
        lUser.add(new User("Иван", 25));
        SortUser su = new SortUser();
        User[] usrArray = new User[4];
        su.sortByAllFields(lUser).toArray(usrArray);
        assertThat(Arrays.toString(usrArray),
                is("[[25], [30], [20], [25]]"));
        assertThat(lUser.get(0).getName()
                        + lUser.get(1).getName()
                        + lUser.get(2).getName()
                        + lUser.get(3).getName(),
                is("ИванИванСергейСергей"));
    }
}
