package ru.job4j.chess.algo;

import ru.job4j.chess.IBoard;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;

/**
 * Класс движения фигуры тура
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Rook extends MoveAlgo {
    public Rook(IBoard ib) {
        super(ib);
    }

    @Override
    public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException {
        int koefX = Integer.compare(dest.x, source.x);
        int koefY = Integer.compare(dest.y, source.y);
        if (!(koefX == 0 ^ koefY == 0)) {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        Cell[] cells = new Cell[Math.abs(dest.x - source.x) + Math.abs(dest.y - source.y)];
        for (int i = 1; i < cells.length + 1; i++) {
            cells[i - 1] = Cell.getCell(source.x + i * koefX, source.y + i * koefY);
        }
        return cells;
    }
}
