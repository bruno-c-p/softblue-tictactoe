package br.com.brunocp.tictactoe;

import br.com.brunocp.tictactoe.core.Game;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Jogo da Velha");

        Game game = new Game();
        game.play();
    }
}
