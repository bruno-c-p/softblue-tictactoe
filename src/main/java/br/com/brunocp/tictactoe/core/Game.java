package br.com.brunocp.tictactoe.core;

import br.com.brunocp.tictactoe.Constants;
import br.com.brunocp.tictactoe.core.exceptions.InvalidMoveException;
import br.com.brunocp.tictactoe.score.FileScoreManager;
import br.com.brunocp.tictactoe.score.ScoreManager;
import br.com.brunocp.tictactoe.ui.UI;

import java.io.IOException;
import java.util.Arrays;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.PLAYER_SYMBOLS.length];
    private int currentPlayerIndex = -1;
    private ScoreManager scoreManager;

    public void play() throws IOException {

        scoreManager = createScoreManager();

        UI.printGameTitle();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

        boolean gameEnded = false;

        Player currentPlayer = nextPlayer();

        Player winner = null;

        while (!gameEnded) {

            board.print();

            boolean sequenceFound;

            try {

                sequenceFound = currentPlayer.play();

            } catch (InvalidMoveException e) {

                UI.printText("Erro: " + e.getMessage());
                continue;
            }

            if (sequenceFound) {

                gameEnded = true;
                winner = currentPlayer;

            } else if (board.isFull()) {

                gameEnded = true;

            }

            currentPlayer = nextPlayer();
        }

        if (winner == null) {

            UI.printText("O jogo terminou empatado!");

        } else {

            UI.printText("o jogador '" + winner.getName() + "' venceu o jogo!");

            scoreManager.saveScore(winner);
        }

        board.print();

        UI.printText("FIM DO JOGO!");
    }

    private Player createPlayer(int index) {

        String name = UI.readInput("Jogador " + (index + 1) + " =>");

        Player player = new Player(name, board, Constants.PLAYER_SYMBOLS[index]);

        Integer score = scoreManager.getScore(player);

        if (score != null) {

            UI.printText("O jogador " + player.getName() + " já possui " + score + " vitória(s)!" );
        }

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

    private ScoreManager createScoreManager() throws IOException {
        return new FileScoreManager();
    }
}
