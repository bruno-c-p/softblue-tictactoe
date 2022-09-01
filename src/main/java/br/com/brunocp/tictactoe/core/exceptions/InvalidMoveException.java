package br.com.brunocp.tictactoe.core.exceptions;

import java.io.Serializable;

public class InvalidMoveException extends Exception {

    public InvalidMoveException(String message) {
        super(message);
    }
}
