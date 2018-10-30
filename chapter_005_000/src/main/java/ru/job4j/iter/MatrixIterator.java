package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MatrixIterator
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class MatrixIterator implements Iterator<Integer> {
    public MatrixIterator(int[][] arr) {
        this.arr = arr;
        row = 0;
        column = 0;
    }

    private int row;
    private int column;
    private int[][] arr;

    @Override
    public boolean hasNext() {
        return arr.length - 1 > row || (arr.length - 1 == row && column <= arr[row].length - 1);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = arr[row][column];
        if (column >= arr[row].length - 1) {
            row++;
            column = 0;
        } else {
            column++;
        }
        return result;
    }
}
