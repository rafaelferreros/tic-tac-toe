package com.metronom.test.tictactoe;

import com.metronom.test.tictactoe.ui.BoardView;
import com.metronom.test.tictactoe.ui.BoardViewTerminal;

import java.util.Scanner;

public class Application {

    public static void main(String [] args){


        Game game = new Game();
        game.start();

        for(int i = 0; i<5; i++)
            game.play(i,i);

        BoardView boardView = new BoardViewTerminal();

        for(int i=0; i < 10; i++){
            boardView.show(game.getBoard());
            boardView.playTurn(game);
        }

    }
}
