package ru.job4j.queue;

/**
 * PriorityQueueTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 2));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
    @Test
    public void whenNumersPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("0", 0));
        queue.put(new Task("-1", -1));
        queue.put(new Task("32", 32));
        queue.put(new Task("3", 3));
        queue.put(new Task("1", 1));
        queue.put(new Task("2", 2));
        queue.put(new Task("12", 12));
        queue.put(new Task("-3", -3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("-3"));
    }
}