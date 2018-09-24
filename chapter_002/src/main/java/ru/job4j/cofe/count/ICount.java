package ru.job4j.cofe.count;

import ru.job4j.cofe.*;
/**
 * ICount.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface ICount {
	Integer[] changes(int amount, int price, IMoney[] coins) throws NullPointerException, ArrayIndexOutOfBoundsException;
}
