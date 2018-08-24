package ru.job4j.array;

/**
 * ArrayChar
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        char[] value = prefix.toCharArray();
        boolean result = value.length <= data.length;
        for (int index = 0; index < value.length && result; index++) {
            result = data[index] == value[index];
        }
        return result;
    }

}
