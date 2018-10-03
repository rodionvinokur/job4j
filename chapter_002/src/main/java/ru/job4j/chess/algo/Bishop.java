package ru.job4j.chess.algo;

import ru.job4j.chess.IBoard;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.*;

/**
 * Класс движения фигуры слон
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Bishop extends MoveAlgo {
    public Bishop(IBoard ib) {
        super(ib);
    }

    @Override
    public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException {
        int koefX = Integer.compare(dest.x, source.x);
        int koefY = Integer.compare(dest.y, source.y);
        if (Math.abs(koefX) != Math.abs(koefY) || koefX == 0) {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        Cell[] cells = new Cell[Math.abs(dest.x - source.x)];
        for (int i = 1; i < cells.length + 1; i++) {
            cells[i - 1] = Cell.getCell(source.x + i * koefX, source.y + i * koefY);
        }
        return cells;
    }
}
