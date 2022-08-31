package br.com.brunocp.tictactoe.core;

import br.com.brunocp.tictactoe.Constants;
import br.com.brunocp.tictactoe.ui.UI;

import java.util.Arrays;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.PLAYER_SYMBOLS.length];

    public void play() {

        UI.printGameTitle();
        board.print();
//        UI.readInput("Nome do Jogador: ");
    }
}
