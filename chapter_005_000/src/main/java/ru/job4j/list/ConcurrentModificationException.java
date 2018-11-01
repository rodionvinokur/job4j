package ru.job4j.list;

/**
 * ConcurrentModificationException
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
class ConcurrentModificationException extends RuntimeException {
    public ConcurrentModificationException(String message) {
        super(message);
    }
}