package ru.job4j.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ru.job4j.chess.cell.Cell;
import ru.job4j.chess.figure.*;
import ru.job4j.chess.exception.*;
import ru.job4j.chess.algo.*;

/**
 * Chess - application gui class
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Chess extends Application {
    private static final String JOB4J = "Шахматы на www.job4j.ru";
    private final int size = 8;
    private final IBoard board = new Board();

    private Rectangle buildRectangle(int x, int y, int size, boolean white) {
        Rectangle rect = new Rectangle();
        rect.setX(x * size);
        rect.setY(y * size);
        rect.setHeight(size);
        rect.setWidth(size);
        if (white) {
            rect.setFill(Color.WHITE);
        } else {
            rect.setFill(Color.GRAY);
        }
        rect.setStroke(Color.BLACK);
        return rect;
    }

    private Rectangle buildFigure(int x, int y, int size, String image) {
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setHeight(size);
        rect.setWidth(size);
        Image img = new Image(this.getClass().getClassLoader().getResource(image).toExternalForm());
        rect.setFill(new ImagePattern(img));
        final Rectangle momento = new Rectangle(x, y);
        rect.setOnDragDetected(
                event -> {
                    momento.setX(event.getX());
                    momento.setY(event.getY());
                }
        );
        rect.setOnMouseDragged(
                event -> {
                    rect.setX(event.getX() - size / 2);
                    rect.setY(event.getY() - size / 2);
                }
        );
        rect.setOnMouseReleased(
                event -> {
                    try {
                        board.move(this.findBy(momento.getX(), momento.getY()), this.findBy(event.getX(), event.getY()));
                        rect.setX(((int) event.getX() / 40) * 40 + 5);
                        rect.setY(((int) event.getY() / 40) * 40 + 5);
                    } catch (FigureNotFoundException | ImpossibleMoveException | OccupiedWayException e) {
                        rect.setX(((int) momento.getX() / 40) * 40 + 5);
                        rect.setY(((int) momento.getY() / 40) * 40 + 5);
                        System.out.println(e.getMessage());
                    }
                }
        );
        return rect;
    }

    private Group buildGrid() {
        Group panel = new Group();
        for (int y = 0; y != this.size; y++) {
            for (int x = 0; x != this.size; x++) {
                panel.getChildren().add(
                        this.buildRectangle(x, y, 40, (x + y) % 2 == 0)
                );
            }
        }
        return panel;
    }

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0);
        control.setAlignment(Pos.BASELINE_CENTER);
        Button start = new Button("Начать");
        start.setOnMouseClicked(
                event -> this.refresh(border)
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(this.buildGrid());
        stage.setScene(new Scene(border, 400, 400));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
        this.refresh(border);
    }

    private void refresh(final BorderPane border) {
        Group grid = this.buildGrid();
        this.board.clean();
        border.setCenter(grid);
        this.buildWhiteTeam(grid);
        this.buildBlackTeam(grid);
    }

    private void buildBlackTeam(Group grid) {
        try {
            this.add(FigureBlack.createFigure(Cell.A7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.B7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.C7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.D7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.E7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.F7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.G7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.H7, new PawnBlack(board)), grid);
            this.add(FigureBlack.createFigure(Cell.A8, new Rook(board)), grid);
            this.add(FigureBlack.createFigure(Cell.B8, new Knight(board)), grid);
            this.add(FigureBlack.createFigure(Cell.C8, new Bishop(board)), grid);
            this.add(FigureBlack.createFigure(Cell.D8, new King(board)), grid);
            this.add(FigureBlack.createFigure(Cell.E8, new Queen(board)), grid);
            this.add(FigureBlack.createFigure(Cell.F8, new Bishop(board)), grid);
            this.add(FigureBlack.createFigure(Cell.G8, new Knight(board)), grid);
            this.add(FigureBlack.createFigure(Cell.H8, new Rook(board)), grid);
        } catch (FigureNotFoundException | ImpossibleMoveException | OccupiedWayException e) {
            System.out.println("No");
        }
    }

    public void buildWhiteTeam(Group grid) {
        try {
            this.add(FigureWhite.createFigure(Cell.A2, new PawnWhite(board)), grid);
            this.add(FigureWhite.createFigure(Cell.B2, new PawnWhite(board)), grid);
            this.add(FigureWhite.createFigure(Cell.C2, new PawnWhite(board)), grid);
            this.add(FigureWhite.createFigure(Cell.D2, new PawnWhite(board)), grid);
            this.add(FigureWhite.createFigure(Cell.E2, new PawnWhite(board)), grid);
            this.add(FigureWhite.createFigure(Cell.F2, new PawnWhite(board)), grid);
            this.add(FigureWhite.createFigure(Cell.G2, new PawnWhite(board)), grid);
            this.add(FigureWhite.createFigure(Cell.H2, new PawnWhite(board)), grid);

            this.add(FigureWhite.createFigure(Cell.A1, new Rook(board)), grid);
            this.add(FigureWhite.createFigure(Cell.B1, new Knight(board)), grid);
            this.add(FigureWhite.createFigure(Cell.C1, new Bishop(board)), grid);
            this.add(FigureWhite.createFigure(Cell.D1, new King(board)), grid);
            this.add(FigureWhite.createFigure(Cell.E1, new Queen(board)), grid);
            this.add(FigureWhite.createFigure(Cell.F1, new Bishop(board)), grid);
            this.add(FigureWhite.createFigure(Cell.G1, new Knight(board)), grid);
            this.add(FigureWhite.createFigure(Cell.H1, new Rook(board)), grid);
        } catch (FigureNotFoundException | ImpossibleMoveException | OccupiedWayException e) {
            System.out.println("No");
        }
    }

    public void add(Figure figure, Group grid)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        this.board.add(figure);
        Cell position = figure.position();
        grid.getChildren().add(
                this.buildFigure(
                        position.x * 40 + 5,
                        position.y * 40 + 5,
                        30,
                        figure.icon()
                )
        );
    }

    private Cell findBy(double graphX, double graphY) {
        Cell rst = Cell.A1;
        int x = (int) graphX / 40;
        int y = (int) graphY / 40;
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                rst = cell;
                break;
            }
        }
        return rst;
    }
}