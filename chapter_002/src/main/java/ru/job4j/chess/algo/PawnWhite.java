package ru.job4j.chess.algo;

import ru.job4j.chess.Figurable;
import ru.job4j.chess.IBoard;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;

/**
 * Класс движения белой пешки
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class PawnWhite extends MoveAlgo implements Figurable {

    public PawnWhite(IBoard ib) {
        super(ib);
    }

    public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (!(Math.abs(deltaX) == 0 && (deltaY == 1 || (deltaY == 2 && source.y == 1)))) {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        if (ib.isBusy(dest) || (deltaY == 2 && ib.isBusy(Cell.getCell(dest.x, dest.y - 1)))) {
            return new Cell[0];
        }
        return deltaY == 1 ? new Cell[]{dest} : new Cell[]{Cell.getCell(dest.x, dest.y - 1), dest};
    }
}

