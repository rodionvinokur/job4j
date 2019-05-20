package ru.job4j.switcher;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Writer
 *
 * @author Rodion V.
 * @version 2.0
 * @since 1.0
 */
public class Writer {
    public static final Integer TEST_COUNT = 3;
    private volatile int prevNumber = 2;
    private final Wrapper rep;
    /**
     * @param rep
     */
    public Writer(Wrapper rep) {
        this.rep = rep;
    }

    public void run(int number) {
        for (int i = 0; i < Writer.TEST_COUNT; i++) {
            while (number == prevNumber) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
               rep.addObj(IntStream.generate(() -> number)
                        .limit(10)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining()), number == prevNumber);
                prevNumber = number;
        }
    }
}
