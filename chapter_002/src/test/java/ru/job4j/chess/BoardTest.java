package ru.job4j.chess;

import ru.job4j.chess.algo.*;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figure.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * BoardTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class BoardTest {

    public void whenCreate(IBoard board, Cell home, Figurable target) {
        boolean result = true;
        Figure fig = FigureBlack.createFigure(home, target);
        try {
            board.add(fig);
        } catch (OccupiedWayException e) {
            result = false;
        }
        assertTrue(board.isBusy(home) && result);
    }

    public void whenMove(IBoard board, Cell home, Cell dest, Figurable target) {
        boolean result = true;
        Figure fig = FigureBlack.createFigure(home, target);
        try {
            board.add(fig);
            board.move(home, dest);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException m) {
            result = false;
        }
        assertTrue(!board.isBusy(home) && result && board.isBusy(dest));
    }

    public void whenWrongMove(IBoard board, Cell home, Cell dest, Figurable target) {
        boolean result = true;
        Figure fig = FigureBlack.createFigure(home, target);
        try {
            board.add(fig);
            board.move(home, dest);
        } catch (OccupiedWayException | ImpossibleMoveException | FigureNotFoundException m) {
            result = false;
        }
        assertTrue(board.isBusy(home) && !result && !board.isBusy(dest));
    }

    public void whenWrongMoveOccup(IBoard board, Cell cellTarget,
                                   Cell cellOccup,
                                   Figurable target,
                                   Figurable occup) {
        boolean result = false;
        Figure fig1 = FigureBlack.createFigure(cellTarget, target);
        Figure fig2 = FigureBlack.createFigure(cellOccup, occup);
        try {
            board.add(fig1);
            board.add(fig2);
            board.move(cellTarget, cellOccup);
        } catch (OccupiedWayException m) {
            result = true;
        } catch (ImpossibleMoveException | FigureNotFoundException m) {

        }
        assertTrue(board.isBusy(cellTarget));
        assertTrue(result);
    }

    public void whenMoveNotExists(IBoard board, Cell source, Cell dest) {
        boolean result = false;
        try {
            board.move(source, dest);
        } catch (OccupiedWayException | ImpossibleMoveException m) {

        } catch (FigureNotFoundException m) {
            result = true;
        }
        assertFalse(board.isBusy(source) || board.isBusy(dest));
        assertTrue(result);
    }

    @Test
    public void whenCreateBoardThenNotNull() {
        IBoard board = new Board();
        assertNotNull(board);
    }

    @Test
    public void whenPawnBlackCreateThenCellDestTrue() {
        IBoard board = new Board();
        whenCreate(board, Cell.A7, new PawnBlack(board));
    }

    @Test
    public void whenPawnBlackMove1ThenCellSourceFalse() {
        IBoard board = new Board();
        whenMove(board,
                Cell.A7,
                Cell.A6,
                new PawnBlack(board));
    }

    @Test
    public void whenPawnBlackMove2FromStartThenCellSourceFalse() {
        IBoard board = new Board();
        whenMove(board,
                Cell.A7,
                Cell.A5,
                new PawnBlack(board));
    }

    @Test
    public void whenPawnBlackWrongMoveBackThenCellSourceTrue() {
        IBoard board = new Board();
        whenWrongMove(board, Cell.A7, Cell.A8, new PawnBlack(board));
    }

    @Test
    public void whenPawnBlackWrongMoveOccupThenCellSourceTrue() {
        IBoard board = new Board();
        whenWrongMoveOccup(board,
                Cell.A7,
                Cell.A6,
                new PawnBlack(board),
                new PawnBlack(board));
    }

    @Test
    public void whenPawnBlackMoveNotExistsFigThenException() {
        IBoard board = new Board();
        whenMoveNotExists(board, Cell.A7, Cell.A6);
    }

    @Test
    public void whenBishopBlackCreateThenCellDestTrue() {
        IBoard board = new Board();
        whenCreate(board, Cell.A7, new Bishop(board));
    }

    @Test
    public void whenBishopBlackMove1ThenCellSourceFalse() {
        IBoard board = new Board();
        whenMove(board,
                Cell.A7,
                Cell.F2,
                new Bishop(board));
    }

    @Test
    public void whenBishopBlackMove2FromStartThenCellSourceFalse() {
        IBoard board = new Board();
        whenMove(board,
                Cell.E4,
                Cell.H7,
                new Bishop(board));
    }

    @Test
    public void whenBishopBlackWrongMoveBackThenCellSourceTrue() {
        IBoard board = new Board();
        whenWrongMove(board,
                Cell.A7,
                Cell.A8,
                new Bishop(board));
    }

    @Test
    public void whenBishopBlackWrongMoveOccupThenCellSourceTrue() {
        IBoard board = new Board();
        whenWrongMoveOccup(board,
                Cell.A7,
                Cell.F2,
                new Bishop(board),
                new PawnBlack(board));
    }
}
