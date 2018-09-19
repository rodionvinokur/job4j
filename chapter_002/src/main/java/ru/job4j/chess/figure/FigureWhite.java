package ru.job4j.chess.figure;

import ru.job4j.chess.Figurable;
import ru.job4j.chess.cell.Cell;
/**
 * FigureWhite - for all white figures
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FigureWhite extends Figure {

	private FigureWhite(Cell cell, String name, Figurable fig) {
		super(cell, name, fig);
	}
	
	public static FigureWhite createFigure(Cell cell, Figurable fig) {
		String str = fig.getClass().getSimpleName();
		return new FigureWhite(cell, str.contains("White") ? str : str + "White", fig);
	}

	@Override
	public Figure copy(Cell dest) {
		return FigureWhite.createFigure(dest, this);
	}
}
