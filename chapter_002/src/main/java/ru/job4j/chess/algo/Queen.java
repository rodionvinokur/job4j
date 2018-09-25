package ru.job4j.chess.algo;

import ru.job4j.chess.IBoard;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * Класс движения фигуры ферзь
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Queen extends MoveAlgo {
    public Queen(IBoard ib) {
        super(ib);
    }

    public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException {
        this.setFig(new Rook(ib).setFig(new Bishop(ib)));
        throw new ImpossibleMoveException("Исключение для включения режима обертки");
    }


}
