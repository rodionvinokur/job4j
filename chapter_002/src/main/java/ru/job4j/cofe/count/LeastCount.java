package ru.job4j.cofe.count;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.cofe.IMoney;
/**
 * LeastCount.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class LeastCount implements ICount {
    /**
     * Вариант жадного алгоритма. Если не находит решение, то перебор.
     *
     * @param amount
     * @param price
     * @param coins
     * @return
     * @throws NullPointerException
     * @throws ArrayIndexOutOfBoundsException
     */
    @Override
    public Integer[] changes(int amount, int price, IMoney[] coins)
            throws NullPointerException, ArrayIndexOutOfBoundsException {
        int quantity = coins.length;
        amount = amount - price;
        int amountBak = amount;
        boolean result = false;
        Integer[] maxKoef = new Integer[quantity];
        int index = 0;

        for (index = 0; index < quantity; index++) {
            maxKoef[index] = amount / coins[index].getDenom();
            if (maxKoef[index] > 0) {
                if (amount % coins[index].getDenom() == 0) {
                    result = true;
                    break;
                }
                amount -= maxKoef[index] * coins[index].getDenom();
            } else {
                continue;
            }
        }
        if (!result) {
            maxKoef = changesNaivnyAlgo(amountBak, coins);
            index = maxKoef.length - 1;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i <= index; i++) {
            for (int j = 0; j < maxKoef[i]; j++) {
                tmp.add(coins[i].getDenom());
            }
        }

        return tmp.toArray(new Integer[tmp.size()]);
    }

    /**
     * Перебор с поиском минимальной комбинации монет.
     * Сделано с условием возможного сокращения набора монет
     * @param amount
     * @param coins
     * @return
     */
    private Integer[] changesNaivnyAlgo(int amount, IMoney[] coins) {
        int quantity = coins.length;
        boolean result = false;
        int[] maxKoef = new int[quantity];
        int tmpAmount = 0;
        Integer[] minKoef = new Integer[quantity];
        int minKoefAmount = 0;
        for (int i = 0; i < quantity; i++) {
            maxKoef[i] = amount / coins[i].getDenom();
            minKoefAmount += maxKoef[i];
            minKoef[i] = 0;
        }
        if (quantity > 0) {
            for (int i = 0; i <= maxKoef[0]; i++) {
                if (quantity > 1) {
                    for (int j = 0; j <= maxKoef[1]; j++) {
                        if (quantity > 2) {
                            for (int k = 0; k <= maxKoef[2]; k++) {
                                if (quantity > 3) {
                                    for (int l = 0; l <= maxKoef[3]; l++) {
                                        tmpAmount = i * coins[0].getDenom() + j * coins[1].getDenom()
                                                + k * coins[2].getDenom() + l * coins[3].getDenom();
                                        if (amount == tmpAmount && minKoefAmount > (i + j + k + l)) {
                                            minKoef[0] = i;
                                            minKoef[1] = j;
                                            minKoef[2] = k;
                                            minKoef[3] = l;
                                            minKoefAmount = i + j + k + l;
                                            result = true;
                                        }
                                    }
                                } else {
                                    tmpAmount = i * coins[0].getDenom() + j * coins[1].getDenom()
                                            + k * coins[2].getDenom();
                                    if (amount == tmpAmount && minKoefAmount > i + j + k) {
                                        minKoef[0] = i;
                                        minKoef[1] = j;
                                        minKoef[2] = k;
                                        minKoefAmount = i + j + k;
                                        result = true;
                                    }
                                }
                            }
                        } else {
                            tmpAmount = i * coins[0].getDenom() + j * coins[1].getDenom();
                            if (amount == tmpAmount && minKoefAmount > i + j) {
                                minKoef[0] = i;
                                minKoef[1] = j;
                                minKoefAmount = i + j;
                                result = true;
                            }
                        }
                    }
                }
            }
        }
        return result ? minKoef : null;
    }
}
