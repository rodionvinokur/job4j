package ru.job4j.chat;

import java.io.IOException;

/**
 * Class Main
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
class Main {
    public static void main(String[] args) {
        try {
            Dialog bot = new Dialog();
            bot.init();
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
