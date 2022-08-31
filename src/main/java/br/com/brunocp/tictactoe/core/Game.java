package br.com.brunocp.tictactoe.core;

import br.com.brunocp.tictactoe.Constants;
import br.com.brunocp.tictactoe.ui.UI;

import java.util.Arrays;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.PLAYER_SYMBOLS.length];
    private int currentPlayerIndex = 0;

    public void play() {

        UI.printGameTitle();
        board.print();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }
    }

    private Player createPlayer(int index) {

        String name = UI.readInput("Jogador " + (index + 1) + " =>");

        Player player = new Player(name, board, Constants.PLAYER_SYMBOLS[index]);

        UI.printText("O jogador '" + player.getName() + "' vai usar o símbolo '" + Constants.PLAYER_SYMBOLS[index] + "'");

        return player;
    }

    private Player nextPlayer() {

        currentPlayerIndex++;

        if (currentPlayerIndex >= players.length) {

            currentPlayerIndex = 0;
        }

        return players[currentPlayerIndex];
    }
}
