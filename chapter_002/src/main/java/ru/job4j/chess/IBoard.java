package ru.job4j.chess;

import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Figure;
/**
 * IBoard
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface IBoard {
public boolean isBusy(Cell cell);
public boolean add(Figure figure) throws OccupiedWayException;
public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException;
public void clean();
}
