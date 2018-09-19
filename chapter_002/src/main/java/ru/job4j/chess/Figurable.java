package ru.job4j.chess;

import ru.job4j.chess.algo.MoveAlgo;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Figure;
/**
 * Figurable
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public interface Figurable {
	Figure copy(Cell dest)  throws ImpossibleMoveException;
	Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException;
}
