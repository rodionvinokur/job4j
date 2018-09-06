package ru.job4j.track;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.track.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by slevi on 05.09.2018.
 */
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setOut() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOut() {
        System.setOut(stdout);
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenWrongMenuNumberThenSizeFindAllZerro() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"7", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void whenDeleteItemThenFindIsNull() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name2", "desc2"));
        Item item = tracker.add(new Item("Delete", "desc"));
        assertNotNull(tracker.findById(item.getId()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenDeleteItemThenResultMinus1() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name1", "desc1"));
        Item item = tracker.add(new Item("Delete", "desc2"));
        tracker.add(new Item("test name3", "desc3"));
        assertNotNull(tracker.findById(item.getId()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }
}
