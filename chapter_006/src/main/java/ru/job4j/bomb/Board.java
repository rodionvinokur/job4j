package ru.job4j.bomb;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Board
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Board {
    private final ReentrantLock[][] locks;
    private final Cell[][] cells;
    private final int sizeX;
    private final int sizeY;
    private final Set<Cell> barries = new HashSet<>();

    private final Map<Cell, Hero> heroes = new ConcurrentHashMap<>();
    private final List<Hero> heroList = Collections.synchronizedList(new ArrayList<>());
    private final Object obj = new Object();

    public Board(final int sizeX,
                 final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        locks = new ReentrantLock[sizeY][sizeX];
        cells = new Cell[sizeY][sizeX];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                cells[i][j] = new Cell(i, j);
                locks[i][j] = new ReentrantLock();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Board board = (Board) o;

        if (sizeX != board.sizeX) {
            return false;
        }
        return sizeY == board.sizeY;
    }

    public List<Hero> getHeroList() {

        return heroList;
    }

    @Override
    public int hashCode() {
        int result = sizeX;

        result = 31 * result + sizeY;
        return result;
    }

    /**
     * Метод move:
     *
     * @param source
     * @param dest   1. Проверка на наличие барьера в dest:
     *               !dest.isBarrier()
     *               Если нет барьера, то:
     *               Достаем, Героя из ячейки source,
     *               сохраняем в hero.
     *               Пытаемся получить блокировку dest.
     *               Если получена:
     *               Значит dest пуст. Создаем "нового текущего" героя и помещаем его в Мап.
     *               удалем "старого текущего" героя из мапы
     *               Отпускаем блокировку с source.
     *               heroes - для быстрого доступа к Герою через Ячейку
     *               heroList - для закрепления героя за конкретным потоком по индексу героя.
     * @return
     */
    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        Hero hero = heroes.get(source);
        Lock lock = getCellLock(dest);
        try {
            if ((lock.tryLock(500L, TimeUnit.MILLISECONDS)) && heroes.get(dest) == null) {
                Class[] params = {Cell.class, Integer.class, Board.class};
                Hero heroNew = heroes.get(source).getClass().getConstructor(params).newInstance(dest, hero.getId(), this);
                if (heroes.putIfAbsent(dest, heroNew) == null) {
                    heroList.set(heroList.indexOf(hero), heroNew);
                    heroes.remove(source, hero);
                    result = true;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalAccessException
                | InstantiationException
                | NoSuchMethodException
                | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    public boolean addBarriers(Cell cell) {
        boolean result = false;
        ReentrantLock lock = getCellLock(cell);
        if (!lock.isLocked() && !barries.contains(cell) && !this.heroes.containsKey(cell)) {
            this.barries.add(cell);
            System.out.println("add " + "Barrier: " + " TO: " + cell);
            lock.lock();
            result = true;
        }
        return result;
    }

    public boolean addHeroes(Hero hero) {
        Cell cell = hero.getCell();
        boolean result = false;
        if (!this.heroes.containsKey(cell) && !barries.contains(cell)) {
            this.heroes.putIfAbsent(cell, hero);
            this.heroList.add(hero);
            System.out.println("add " + (hero.getId() == 0 ? "Bomberman: id:" : "Monster: id:") + " " + hero.getId()
                    + " TO: " + cell);
            result = true;
        }
        return result;
    }

    private ReentrantLock getCellLock(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        return locks[y][x];
    }

    public Cell[] generateStepVariants(Board.Cell source) {
        int x1 = source.getX();
        int y1 = source.getY();
        ArrayList<Cell> variants = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(i == j && i == 0)) {
                    int x2 = x1 + j;
                    int y2 = y1 + i;
                    Cell cell = null;
                    try {
                        cell = this.getCell(y2, x2);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    if (x2 > -1
                            && y2 > -1
                            && x2 < this.sizeX
                            && y2 < this.sizeY
                            && !barries.contains(cell)) {
                        variants.add(getCell(y2, x2));
                    }
                }
            }
        }
        return variants.toArray(new Cell[0]);
    }

    public Cell getCell(int y, int x) {
        if (x >= this.sizeX || x < 0 || y >= sizeY || y < 0) {
            throw new IllegalArgumentException();
        }
        return this.cells[y][x];
    }

    public class Cell {
        private final int x;
        private final int y;

        private Cell(final int y, final int x) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Cell cell = (Cell) o;

            if (getX() != cell.getX()) {
                return false;
            }
            return getY() == cell.getY();
        }

        @Override
        public int hashCode() {
            int result = getX();
            result = 31 * result + getY();
            return result;
        }

        @Override
        public String toString() {
            return "Cell{" + "x=" + x + ", y=" + y + '}';
        }
    }

}
