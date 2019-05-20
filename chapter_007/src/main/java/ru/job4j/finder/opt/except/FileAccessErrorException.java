package ru.job4j.finder.opt.except;

/**
 * Class FileAccessErrorException
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class FileAccessErrorException extends RuntimeException {
    public FileAccessErrorException(String message) {
        super(message);
    }
}
