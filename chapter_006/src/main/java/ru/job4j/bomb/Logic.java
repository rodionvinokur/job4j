package ru.job4j.bomb;

import java.util.List;
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
        int monsterNumber = 2;
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

        List<Hero> lh = board.getHeroList();
        Thread[] threads = new Thread[lh.size()];
        for (int i = 0; i < lh.size(); i++) {
            Hero hero = lh.get(i);
            threads[i] = new Thread(new BombThread(hero.getId(), board), hero.getId() == 0 ? "Bomberman: " : "Monster: "
                    + hero.getId());
            threads[i].start();
        }
        try {
            threads[0].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
