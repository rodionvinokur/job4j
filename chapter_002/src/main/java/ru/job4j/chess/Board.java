package ru.job4j.chess;

import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.Figure;

/**
 * Board
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Board implements IBoard {

    private Figure[] figures;
    private int position;
    private final static int SIZE = 32;

    public Board() {
        this.figures = new Figure[SIZE];
   }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = findByCell(source);
        if (index == -1) {
            throw new FigureNotFoundException("В этой ячейке нет фигуры: " + source);
        }
        Cell[] steps = figures[index].way(figures[index].position(), dest);
        if (steps.length == 0) {
            throw new OccupiedWayException("Путь занят.");
        }
        figures[index] = figures[index].copy(dest);
        return true;
    }

    public boolean add(Figure figure) throws OccupiedWayException {
        if (this.isBusy(figure.position())) {
            throw new OccupiedWayException("Поле занято: " + figure.position());
        }
        if (position != SIZE) {
            figures[position++] = figure;
            return true;
        }
        return false;
    }

    public boolean isBusy(Cell cell) {
        return findByCell(cell) != -1;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.position = 0;
    }

    private int findByCell(Cell cell) {
        int index = -1;
        for (int i = 0; i < position && index == -1; i++) {
            if (figures[i].position().equals(cell)) {
                index = i;
            }
        }
        return index;
    }
}
