package ru.job4j.pingpong;

/**
 * RectangleMove
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

import javafx.scene.shape.Rectangle;

import java.util.function.BiFunction;


public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int stepX = 5;
    private int stepY = 5;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        BiFunction<Double, Integer, Integer> func = (x, y) -> {
            if (x == 300) {
                y = -5;
            }
            if (x == 0) {
                y = 5;
            }
            return y;
        };
        while (true) {
            double posX = this.rect.getX();
            stepX = func.apply(posX, stepX);
            double posY = this.rect.getY();
            stepY = func.apply(posY, stepY);
            this.rect.setX(posX + stepX);
            this.rect.setY(posY + stepY);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
