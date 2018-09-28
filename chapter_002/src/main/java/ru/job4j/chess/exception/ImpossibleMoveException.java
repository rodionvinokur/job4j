package ru.job4j.chess.exception;

/**
 * ImpossibleMoveException
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ImpossibleMoveException extends RuntimeException {
	public ImpossibleMoveException(String message) {
		super(message);
	}
}
