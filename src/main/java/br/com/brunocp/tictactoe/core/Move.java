package br.com.brunocp.tictactoe.core;

public class Move {

    private int i;
    private int j;

    public Move(String move) {

        String[] moves = move.split(",");

        this.i = Integer.parseInt(moves[0]);
        this.j = Integer.parseInt(moves[1]);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
