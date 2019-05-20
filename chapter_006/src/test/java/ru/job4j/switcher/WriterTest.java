package ru.job4j.switcher;

import static javax.management.Query.in;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.regex.Matcher;

/**
 * WriterTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class WriterTest {
    Wrapper wrp = new Wrapper();
    Writer w;
    Semaphore sem;
    CyclicBarrier cyc;

    @Before
    public void setUp() {
        sem = new Semaphore(1);
        cyc = new CyclicBarrier(2);
        w = new Writer(wrp);
    }

    @Test
    public void testWhenWrappWhen3Times() throws InterruptedException, ExecutionException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
            Future<?> f1 = ex.submit(() -> w.run(1));
            Future<?> f2 = ex.submit(() -> w.run(2));
            f1.get();
            f2.get();
        System.out.println(wrp.getString());
        assertEquals("111111111122222222221111111111222222222211111111112222222222", wrp.getString());
    }
}
