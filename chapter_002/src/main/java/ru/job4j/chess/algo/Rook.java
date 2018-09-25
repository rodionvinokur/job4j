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
    public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (!(Math.abs(deltaX) == 0 ^ Math.abs(deltaY) == 0)) {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        Cell[] cells = new Cell[Math.abs(deltaX) + Math.abs(deltaY)];
        for (int i = 1; i < cells.length + 1; i++) {
            int tmpX = source.x + i * (deltaX > 0 ? 1 : deltaX == 0 ? 0 : -1);
            int tmpY = source.y + i * (deltaY > 0 ? 1 : deltaY == 0 ? 0 : -1);
            Cell tmp = Cell.A1.getCell(tmpX, tmpY);
            if (ib.isBusy(tmp)) {
                throw new OccupiedWayException("Ход невозможен, путь занят");
            }
            cells[i - 1] = tmp;
        }
        return cells;
    }
}
