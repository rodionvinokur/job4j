package ru.job4j.switcher;

import java.util.concurrent.CountDownLatch;

/**
 * Writer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Writer {
    public final static int NUMBERS_TEST_RUN = 3;
    private final int number;
    private int count;
    private Wrapper rep;
    private volatile CountDownLatch cdl;

    /**
     * @param number число для записи в строку Враппера (1 или 2)
     * @param count  - Integer: 0..1. Барьер - 0: убран, 1: поставлен
     * @param rep
     */
    public Writer(int number, int count, Wrapper rep) {
        this.number = number;
        cdl = new CountDownLatch(count);
        this.count = count;
        this.rep = rep;
    }

    public CountDownLatch getCdl() {
        return cdl;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void writeNumberToWrapper(Writer w) {
        int j = 0;
        while (j < NUMBERS_TEST_RUN) {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StringBuilder sb = new StringBuilder(rep.getObj());
            String str = "";
            for (int i = 0; i < 10; i++) {
                sb.append(number);
            }
            rep.setObj(sb.toString());
            CountDownLatch oldCdl = cdl;
            cdl = new CountDownLatch(1);
            if (oldCdl != cdl) {
                w.getCdl().countDown();
            }

            j++;
        }
    }
}
