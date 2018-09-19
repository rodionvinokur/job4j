package ru.job4j.chess.algo;

import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Figure;
import ru.job4j.chess.*;
/**
 * MoveAlgo - abstarct for all moves
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public abstract class MoveAlgo implements Figurable {
	private MoveAlgo fig;
	protected IBoard ib;

	public MoveAlgo(IBoard ib) {
		this.fig = null;
		this.ib = ib;
	}

	/**
	 * Метод, обеспечивающий вариативность движения (обертку)
	 * @param source
	 * @param dest
	 * @return
	 * @throws ImpossibleMoveException
	 * @throws OccupiedWayException
	 */
	@Override
	public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
		try {
			return wayAlgo(source, dest);
		} catch (ImpossibleMoveException | OccupiedWayException e) {
			if (this.getFig() != null) {
				return this.getFig().way(source, dest);
			}
			throw e;
		}
	}

	/**
	 * Конкретный метод движения
	 * @param source
	 * @param dest
	 * @return
	 * @throws ImpossibleMoveException
	 * @throws OccupiedWayException
	 */
	public abstract Cell[] wayAlgo(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException;

	public Figurable getFig() {
		return fig;
	}
	
	public MoveAlgo setFig(MoveAlgo fig) {
		this.fig = fig;
		return this;
	}
	
	@Override
	public Figure copy(Cell dest)  throws ImpossibleMoveException {
		return null;
		}


}
