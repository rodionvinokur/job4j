package ru.job4j.coffee;

import java.util.Arrays;

/**
 * Metod for changes.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Metod {

    public int[] changes(int amount, int price) {
        if (amount <= price) {
            return new int[0];
        }
        int[] coins = {1, 2, 5, 10};
        amount = amount - price;
        int length = 0;
        int[] result = new int[0];
        Arrays.sort(coins);
        for (int index = coins.length - 1; index > -1; index--) {
            int count = (amount / coins[index]);
            result = Arrays.copyOf(result, length + count);
            Arrays.fill(result, length, length + count, coins[index]);
            length += count;
            if (count > 0) {
                if (amount % coins[index] == 0) {
                    break;
                }
                amount -= count * coins[index];
            }
        }
        return result;
    }
}
