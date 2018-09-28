package ru.job4j.chess.algo;

import ru.job4j.chess.Figurable;
import ru.job4j.chess.IBoard;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;

/**
 * Класс движения фигуры король
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class King extends MoveAlgo implements Figurable {

    public King(IBoard ib) {
        super(ib);
    }

    public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException {
        int koefX = Integer.compare(dest.x, source.x);
        int koefY = Integer.compare(dest.y, source.y);
        if (!((Math.abs(koefX) == 1 && Math.abs(koefY) <= 1)
                || ((Math.abs(koefX) <= 1 && Math.abs(koefY) == 1)))) {
            throw new ImpossibleMoveException("Ход невозможен, путь занят");
        }
        if (ib.isBusy(dest)) {
            return new Cell[0];
        }
        return new Cell[]{dest};
    }
}
