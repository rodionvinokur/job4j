package ru.job4j.track;

import org.junit.Test;
import ru.job4j.track.Item;
import ru.job4j.track.Tracker;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for Tracker.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class TrackerTest {

    @Test
    public void whenAddItemNullThenNull() {
        Tracker track  = new Tracker();
        Item expected = null;
        Item result = track.add(null);
        assertNull(result);
    }

    @Test
    public void whenAddItemNotNullThenItem() {
        Tracker track  = new Tracker();
        Item expected = new Item("Test", "Test");
        Item result = track.add(expected);
        assertThat(result.getName(), is("Test"));
        assertThat(result.getDesc(), is("Test"));
        assertNotNull(result.getId());
    }

    @Test
    public void whenOneOfParamNullAddItemThenItem() {
        Tracker track  = new Tracker();
        Item expected = new Item("Test", null);
        Item result = track.add(expected);
        assertNull(result.getDesc());
        assertThat(result.getName(), is("Test"));
    }

    @Test
    public void whenReplaceItemThenItemChange() {
        Tracker track  = new Tracker();
        Item exp1 = new Item("Test1", "Desc1");
        Item exp2 = new Item("Test2", "Desc2");
        Item exp3 = new Item("Test3", "Desc3");
        track.add(exp1);
        track.add(exp2);
        String id = exp1.getId();
        track.replace(id, exp3);
        assertThat(track.getItems().get(0).getName(), is("Test3"));
    }
    @Test
    public void whenfindAllItem3ThenSize3() {
        Tracker track  = new Tracker();
        Item exp1 = new Item("Test1", "Desc1");
        Item exp2 = new Item("Test2", "Desc2");
        Item exp3 = new Item("Test3", "Desc3");
        track.add(exp1);
        track.add(exp2);
        track.add(exp3);
        int result = track.findAll().size();
        assertThat(result, is(3));
    }

    @Test
    public void whenfindAllItem0ThenSize0() {
        Tracker track  = new Tracker();
        int result = track.findAll().size();
        assertThat(result, is(0));
    }

    @Test
    public void whenfindByIdItemThenItem() {
        Tracker track  = new Tracker();
        Item exp1 = new Item("Test1", "Desc1");
        Item exp2 = new Item("Test2", "Desc2");
        Item exp3 = new Item("Test3", "Desc3");
        Item exp5 = new Item("Test4", "Desc4");
        Item exp4 = new Item("Test5", "Desc5");
        track.add(exp1);
        track.add(exp2);
        String id = exp2.getId();
        Item result = track.findById(id);
        assertThat(result.getId(), is(id));
    }

    @Test
    public void whenfindByIdSizeNullItemThenItemNull() {
        Tracker track  = new Tracker();
        String id = "";
        Item result = track.findById(id);
        assertNull(result);
    }

    @Test
    public void whenfindByNameThenArrayOfItem() {
        Tracker track  = new Tracker();
        Item exp1 = new Item("Test", "Desc1");
        Item exp2 = new Item("Test2", "Desc2");
        Item exp3 = new Item("Test3", "Desc3");
        Item exp5 = new Item("Test", "Desc4");
        Item exp4 = new Item("Test5", "Desc5");
        track.add(exp1);
        track.add(exp2);
        track.add(exp3);
        track.add(exp4);
        track.add(exp5);
        List<Item> result = track.findByName("Test");
        assertThat(result.size(), is(2));
    }

    @Test
    public void whenDeleteLastThenCopyToLast() {
        Tracker track  = new Tracker();
        Item exp1 = new Item("Test1", "Desc1");
        Item exp2 = new Item("Test2", "Desc2");
        Item exp3 = new Item("Test3", "Desc3");
        Item exp5 = new Item("Test4", "Desc4");
        Item exp4 = new Item("Test5", "Desc5");
        track.add(exp1);
        track.add(exp2);
        track.add(exp3);
        track.add(exp4);
        track.add(exp5);
        String id = exp5.getId();
        track.delete(id);
        List<Item> result = track.findAll();
        assertThat(track.getItems().get(result.size() - 1).getId(), is(exp4.getId()));
    }

    @Test
    public void whenDeleteEmtyThenNothing() {
        Tracker track  = new Tracker();
        Item exp1 = new Item("Test1", "Desc1");
        Item exp2 = new Item("Test2", "Desc2");
        Item exp3 = new Item("Test3", "Desc3");
        Item exp5 = new Item("Test4", "Desc4");
        Item exp4 = new Item("Test5", "Desc5");
        String id = exp5.getId();
        track.delete(id);
        List<Item> result = track.findAll();
        assertThat(result.size(), is(0));
    }

    @Test
    public void whenDeleteMiddleThen() {
        Tracker track  = new Tracker();
        Item exp1 = new Item("Test1", "Desc1");
        Item exp2 = new Item("Test2", "Desc2");
        Item exp3 = new Item("Test3", "Desc3");
        Item exp4 = new Item("Test4", "Desc4");
        Item exp5 = new Item("Test5", "Desc5");
        track.add(exp1);
        track.add(exp2);
        track.add(exp3);
        track.add(exp4);
        track.add(exp5);
        String id = exp4.getId();
        track.delete(id);
        List<Item> result = track.findAll();
        String idResult = track.getItems().get(result.size() - 1).getId();
        String idExp = exp5.getId();
        assertThat(idResult, is(idExp));
    }
}
