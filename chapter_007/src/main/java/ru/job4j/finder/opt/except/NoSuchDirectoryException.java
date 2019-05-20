package ru.job4j.finder.opt.except;

/**
 * Class NoSuchDirectoryException
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class NoSuchDirectoryException extends RuntimeException {
    public NoSuchDirectoryException(String message) {
        super(message);
    }
}
