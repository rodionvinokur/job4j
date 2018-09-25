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
    public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (Math.abs(deltaX) != Math.abs(deltaY) || deltaX == 0) {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        Cell[] cells = new Cell[Math.abs(deltaX)];
        for (int i = 1; i < cells.length + 1; i++) {
            int tmpX = source.x + i * (deltaX > 0 ? 1 : -1);
            int tmpY = source.y + i * (deltaY > 0 ? 1 : -1);
            Cell tmp = Cell.A1.getCell(tmpX, tmpY);
            if (ib.isBusy(tmp)) {
                throw new OccupiedWayException("Ход невозможен, путь занят");
            }
            cells[i - 1] = tmp;
        }
        return cells;
    }
}
