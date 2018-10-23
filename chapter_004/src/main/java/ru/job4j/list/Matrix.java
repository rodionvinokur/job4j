package ru.job4j.list;

/**
 * Matrix обертка для массива int[][]
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Matrix {
    private int[][] array;
    private int indexRow;
    private int indexColumn;

    private int rows;
    private int columns;

    public Matrix(int[][] t) {
        this.array = t;
        this.indexRow = 0;
        this.indexColumn = 0;
        rows = array.length;
        columns = array[0].length;
    }

    public void addNext(int element) {
        if (indexRow < rows && indexColumn < columns) {
            array[indexRow][indexColumn] = element;
            indexColumn++;
            if (indexColumn == columns) {
                indexColumn = 0;
                indexRow++;
            }
        }
    }

    public int[][] getArray() {
        return array;
    }
}
