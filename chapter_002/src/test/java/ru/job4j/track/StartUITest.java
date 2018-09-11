package ru.job4j.track;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * StartUITest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private StringBuilder menu = new StringBuilder();
    private String ret = System.lineSeparator();

    @Before
    public void setOut() {
        System.setOut(new PrintStream(out));
        menu.append("0. Добавить новую заявку.").append(ret)
                .append("1. Показать все заявки.").append(ret)
                .append("2. Редактировать заявку.").append(ret)
                .append("3. Удалить заявку.").append(ret)
                .append("4. Найти заявку по номеру.").append(ret)
                .append("5. Найти заявку по имени.").append(ret);
    }

    @After
    public void backOut() {
        System.setOut(stdout);
    }

    private void buildForm(String name,
                           String desc,
                           String title,
                           StringBuilder sb,
                           Item item,
                           String... comments) {
        sb.append(title).append(ret);
        buildForm(name, desc, sb, item, comments);
    }

    private void buildForm(String name, String desc, StringBuilder sb, Item item, String... comments) {
        sb.append(String.format("Номер заявки:%4s%s%s", "", item.getId() != null ? item.getId() : "", ret));
        sb.append(String.format("Имя заявки:%6s%s%s", "", name != null ? name : "", ret));
        sb.append(String.format("Дата создания:%3s%tF %<tT%s", "", item.getCreated(), ret));
        sb.append(String.format("Описание заявки:%1s%s%s", "", desc, ret));
        if (comments.length != 0) {
            for (String s : comments) {
                sb.append(String.format("Комментар. заявки: %s%s", s, ret));
            }
        }
        sb.append("-----------------------------------------------------").append(ret);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
         Tracker tracker = new Tracker();
         Item item = tracker.add(new Item("test name", "desc"));
         Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
         new StartUI(input, tracker).init();
         assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenWrongMenuNumberThenSizeFindAll() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"7", "y"});
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
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
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
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }

    @Test
    public void whenShowByIdThen() {
        Tracker tracker = new Tracker();
        String name  = "test name1";
        String desc = "desc1";
        String title = "------------- Поиск по номеру заявки ---------------";
        Item item = tracker.add(new Item(name, desc));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        StringBuilder total = new StringBuilder();
        total.append(menu);
        buildForm(name, desc, title, total, item);
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(total.toString()));
    }

    @Test
    public void whenShowByNameThen() {
        Tracker tracker = new Tracker();
        String name  = "test1";
        String desc = "desc1";
        tracker.add(new Item("test2", "desc2"));
        Item item = tracker.add(new Item(name, desc));
        tracker.add(new Item("test3", "desc3"));
        Input input = new StubInput(new String[]{"5", name, "y"});
        StringBuilder total = new StringBuilder();
        total.append(menu);
        String title = "------------- Поиск по имени заявки ----------------";
        buildForm(name, desc, title, total, item);
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(total.toString()));
    }

    @Test
    public void whenShowAllThen() {
        Tracker tracker = new Tracker();
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item3 = tracker.add(new Item("test3", "desc3"));
        Input input = new StubInput(new String[]{"1", "y"});
        StringBuilder total = new StringBuilder();
        total.append(menu);
        buildForm("test2", "desc2", total, item2);
        buildForm("test1", "desc1", total, item1);
        buildForm("test3", "desc3", total, item3);
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(total.toString()));
    }
}
