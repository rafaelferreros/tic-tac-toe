package com.metronom.test.tictactoe;

import com.metronom.test.tictactoe.controller.GameController;
import com.metronom.test.tictactoe.model.Game;
import com.metronom.test.tictactoe.view.GameView;
import com.metronom.test.tictactoe.view.GameViewTerminal;

public class Application {

    public static void main(String [] args){

        GameController gameController = new GameController();
        gameController.start();

    }

}
