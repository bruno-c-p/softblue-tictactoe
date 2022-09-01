package br.com.brunocp.tictactoe.core;

import br.com.brunocp.tictactoe.ui.UI;

public class Player {

    private String name;
    private Board board;
    private char symbol;

    public Player(String name, Board board, char symbol) {
        this.name = name;
        this.board = board;
        this.symbol = symbol;
    }

    private Move inputMove() {

        String playerMove = UI.readInput("Jogador '" + getName() + "' =>");

        return new Move(playerMove);
    }

    public boolean play() {

        Move move = inputMove();

        return board.play(this, move);
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public char getSymbol() {
        return symbol;
    }
}
