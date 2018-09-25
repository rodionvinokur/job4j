package ru.job4j.chess.figure;

import ru.job4j.chess.Figurable;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;

/**
 * Figure abstract class
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public abstract class Figure implements Figurable {
    private Figurable fig;
    private String name;
    private Cell cell;

    public Figure(Cell cell, String name, Figurable fig) {
        this.name = name;
        this.fig = fig;
        this.cell = cell;
    }

    public Cell position() {
        return this.cell;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        return fig.way(source, dest);
    }

    public String icon() {
        return String.format(
                "%s.png", this.name
        );
    }

    @Override
    public String toString() {
        return name + ": " + this.cell.toString();
    }

    @Override
    public abstract Figure copy(Cell dest) throws ImpossibleMoveException;

}
