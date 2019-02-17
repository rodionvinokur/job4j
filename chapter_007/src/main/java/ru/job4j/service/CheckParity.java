package ru.job4j.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * CheckParity
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class CheckParity {
    private CheckStrategy cs = new IntStrategy();

    public CheckParity(CheckStrategy cs) {
        this.cs = cs;
    }

    public boolean isNumber(InputStream in) throws IOException {
        return cs.check(in);
    }

}
