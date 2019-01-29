package ru.job4j.switcher;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * WriterTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class WriterTest {
    Wrapper wrp = new Wrapper();
    Writer w1;
    Writer w2;

    @Before
    public void setUp() {
        w1 = new Writer(1, 0, wrp);
        w2 = new Writer(2, 1, wrp);
    }

    @Test
    public void testWhenWrappWhen3Times() throws InterruptedException {
        Runnable r1 = () -> w1.writeNumberToWrapper(w2);
        Runnable r2 = () -> w2.writeNumberToWrapper(w1);
        Thread t1 = new Thread(r1, "Mars");
        Thread t2 = new Thread(r2, "Venera");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertEquals("111111111122222222221111111111222222222211111111112222222222", wrp.getObj());
    }
}
