package com.metronom.test.tictactoe;

import com.metronom.test.tictactoe.controller.GameController;

public class Application {

    public static void main(String [] args){

        GameController gameController = new GameController();
        gameController.start();

    }

}
