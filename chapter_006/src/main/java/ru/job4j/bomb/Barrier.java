package ru.job4j.bomb;

/**
 * Barrier
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Barrier {
    private Board.Cell cell;
    private Board board;

    public Barrier(Board.Cell cell) {
        this.cell = cell;
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Barrier barrier = (Barrier) o;

        if (!getCell().equals(barrier.getCell())) {
            return false;
        }
        return board.equals(barrier.board);
    }

    @Override
    public int hashCode() {
        int result = getCell().hashCode();
        result = 31 * result + board.hashCode();
        return result;
    }

    public Board.Cell getCell() {
        return cell;
    }
}
