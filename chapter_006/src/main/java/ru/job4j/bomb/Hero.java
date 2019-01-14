package ru.job4j.bomb;

/**
 * abstract class Hero
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public abstract class Hero {
    protected final Board.Cell cell;
    protected final Integer id;
    protected final Board board;

    public Hero(Board.Cell cell, final Integer id, Board board) {
        this.cell = cell;
        this.id = id;
        this.board = board;
    }

    public Board.Cell getCell() {
        return cell;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Hero hero = (Hero) o;

        return id.equals(hero.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    protected boolean move(Board.Cell dest) {
        return board.move(this.cell, dest);
    }

    private volatile boolean isDead = false;

    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
    }
}
