package ru.job4j.loop;

/**
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Board {

    /**
     * Method paint
     *
     * @param width
     * @param height
     * @return
     */
    public String paint(int width, int height) {
        StringBuilder field = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                  if ((i + j) % 2 == 0) {
                    field.append("X");
                } else {
                    field.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            field.append(ln);
        }
        return field.toString();
    }
}
