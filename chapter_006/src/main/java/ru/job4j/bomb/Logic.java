package ru.job4j.bomb;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Logic
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Logic {
    public static void main(String[] args) {
        int monsterNumber = 5;
        int heightBoard = 5;
        int widthBoard = 5;
        int barrierNumber = 2;
        Board board = new Board(heightBoard, widthBoard);
        board.addHeroes(new Bomberman(board.getCell(0, 1), 0, board));
        IntStream.range(1, barrierNumber + 1).forEach(i -> {
                    boolean stop = false;
                    Random randX = new Random();
                    Random randY = new Random();
                    do {
                        int x = randX.nextInt(widthBoard - 1);
                        int y = randY.nextInt(heightBoard - 1);
                        stop = board.addBarriers(board.getCell(y, x));
                    } while (!stop);
                }
        );
        IntStream.range(1, monsterNumber + 1).forEach(i -> {
                    boolean stop = false;
                    Random randX = new Random();
                    Random randY = new Random();
                    do {
                        int x = randX.nextInt(widthBoard - 1);
                        int y = randY.nextInt(heightBoard - 1);
                        stop = board.addHeroes(new Monster(board.getCell(y, x), i, board));
                    } while (!stop);
                }
        );
        for (Hero hero : board.getHeroList()) {
            Thread thread = new Thread(new BombThread(hero.getId(), board), hero.getId() == 0 ? "Bomberman: " : "Monster: "
                    + hero.getId());
            thread.setDaemon(false);
            thread.start();
        }
    }
}
