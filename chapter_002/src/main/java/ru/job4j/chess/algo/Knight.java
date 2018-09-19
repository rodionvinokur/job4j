package ru.job4j.chess.algo;

import ru.job4j.chess.Figurable;
import ru.job4j.chess.IBoard;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
/**
 * Класс движения фигуры конь
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Knight extends MoveAlgo implements Figurable {

	public Knight(IBoard ib) {
		super(ib);
	}

	public Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
		int deltaX = dest.x - source.x;
		int deltaY = dest.y - source.y;
		if (!((Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1) || (Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2))) {
			throw new ImpossibleMoveException("Ход невозможен");
		}
		if (ib.isBusy(dest)) {
			throw new OccupiedWayException("Ход невозможен, путь занят");
		}
		return new Cell[] {dest};
	}
}

