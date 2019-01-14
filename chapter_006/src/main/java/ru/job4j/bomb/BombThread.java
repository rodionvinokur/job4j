package ru.job4j.bomb;

import java.util.List;
import java.util.Random;

/**
 * Bomberman
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class BombThread implements Runnable {
    private final int id;
    private final Board board;
    private final static int STEP_COUNT = 100;
    private final static int TRY_COUNT = 100;
    private volatile List<Hero> heroList;

    public BombThread(int id, Board board) {
        this.id = id;
        this.board = board;
    }

    @Override
    public void run() {
        heroList = board.getHeroList();
        for (int i = 0; i < STEP_COUNT
                && !Thread.currentThread().isInterrupted()
                && !heroList.get(0).isDead(); i++) {

            try {
                heroList = board.getHeroList();
                Hero hero = heroList.get(id);
                Board.Cell cell = hero.getCell();
                Board.Cell dest = null;
                heroList = board.getHeroList();
                if (heroList.get(id).getClass() == Monster.class) {
                    Board.Cell[] cells = board.generateStepVariants(cell);
                    //System.out.println(Thread.currentThread().getName() + " "+ Arrays.toString(cells));
                    cells = this.shuffle(cells);
                    int sizeCells = cells.length;
                    //System.out.println(Thread.currentThread().getName() + " "+ Arrays.toString(cells));
                    boolean stop = false;
                    int count = 0;
                    int cellNumber = 0;
                    do {
                        dest = cells[cellNumber++];
                        cellNumber = cellNumber == sizeCells ? 0 : cellNumber;
                        //System.out.println("Try ----------------> " + Thread.currentThread().getName() + " "  + dest);
                        stop = board.move(cell, dest);
                        count++;

                    } while (!stop && count < TRY_COUNT);
                    System.out.println(Thread.currentThread().getName() + " FROM: " + " " + hero.getCell() + " TO: "
                            + dest + " try_count = " + count);
                    Thread.sleep(1000);
                } else {
                    if (hero.isDead() || hero.getCell().getCellLock().isLocked()) {
                        hero.setDead();
                        break;
                    }
                    System.out.println("Bomberman next step");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private Board.Cell[] shuffle(Board.Cell[] cells) {
        int sizeCells = cells.length;
        Board.Cell[] newCells = new Board.Cell[sizeCells];
        Random cellRnd = new Random(System.currentTimeMillis());
        int count = sizeCells;
        int i = 0;
        while (count > 0) {
            int j = cellRnd.nextInt(count--);
            newCells[i++] = cells[j];
            System.arraycopy(cells, j + 1, cells, j, cells.length - j - 1);
        }
        return newCells;
    }
}
