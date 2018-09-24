package ru.job4j.cofe.input;
/**
 * StubInput.
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class StubInput implements Input {
    public StubInput(final String[] value) {
        this.value = value;
        this.position = 0;
    }

    private final String[] value;
    private int position;

    @Override
    public int getCode(String q, int range) {
        return Integer.parseInt(this.value[this.position++]);
    }
}
