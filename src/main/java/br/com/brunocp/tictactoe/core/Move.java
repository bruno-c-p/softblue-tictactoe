package br.com.brunocp.tictactoe.core;

import br.com.brunocp.tictactoe.core.exceptions.InvalidMoveException;

public class Move {

    private int i;
    private int j;

    public Move(String move) throws InvalidMoveException {

        try {

            String[] moves = move.split(",");

            this.i = Integer.parseInt(moves[0]);
            this.j = Integer.parseInt(moves[1]);

        } catch (Exception e) {

            throw new InvalidMoveException("A jogada é inválida");
        }
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
