package ru.job4j.tictactoe;

/**
 * TicTacToe
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by slevi on 25.08.2018.
 */

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Winner X
     *
     * @return
     */
    public boolean isWinnerX() {
        return isWinner(f -> f.hasMarkX());
    }
    /**
     * Winner 0
     *
     * @return
     */
    public boolean isWinnerO() {
        return isWinner(f -> f.hasMarkO());
    }

    /**
     * isWinner
     *
     * @param predict
     * @return
     */
    public boolean isWinner(Predicate<Figure3T> predict) {
        boolean result = false;
        boolean rc1 = true;
        boolean rc2 = true;
        for (int i = 0; i < table.length && !result; i++) {
            boolean rc3 = true;
            boolean rc4 = true;
            result  = true;
            for (int j = 0; j < table.length; j++) {
                if (rc1) {
                    rc1 &= predict.test(table[j][table[j].length - 1 - j]);
                }
                if (rc2) {
                    rc2 &= predict.test(table[j][j]);
                }
                rc3 &= predict.test(table[i][j]);
                rc4 &= predict.test(table[j][i]);
            }

            result = rc1 || rc2 || rc3 || rc4;
        }
        return result;
    }

    /**
     * HasGap
     *
     * @return
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < table[0].length && !result; i++) {
            for (int j = 0; j < table[0].length && !result; j++) {
                if (!(table[i][j].hasMarkO() || table[i][j].hasMarkX())) {
                    result = true;
                }
            }
        }
        return result;
    }
}
