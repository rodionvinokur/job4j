package ru.job4j.chess.figure;

import ru.job4j.chess.Figurable;
import ru.job4j.chess.cell.Cell;

/**
 * FigureBlack - for all black figures
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FigureBlack extends Figure {

    private FigureBlack(Cell cell, String name, Figurable fig) {
        super(cell, name, fig);
    }

    public static FigureBlack createFigure(Cell cell, Figurable fig) {
        String str = fig.getClass().getSimpleName();
        return new FigureBlack(cell, str.contains("Black") ? str : str + "Black", fig);
    }

    @Override
    public Figure copy(Cell dest) {
        return FigureBlack.createFigure(dest, this);
    }
}
