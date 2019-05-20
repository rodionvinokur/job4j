package ru.job4j.finder.opt;

import static ru.job4j.finder.opt.OptActions.SPLITTER;

/**
 * Class Option
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Option {
    final protected String option;
    final protected String optionLetter;

    public Option(String option, String optionLetter) {
        this.optionLetter = optionLetter;
        this.option = this.extractOption(option);
    }

    private String extractOption(String str) {
        return SPLITTER.apply(str, optionLetter);
    }
}
