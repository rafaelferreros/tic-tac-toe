package com.metronom.test.tictactoe.controller;

import com.metronom.test.tictactoe.model.Game;
import com.metronom.test.tictactoe.view.GameView;
import com.metronom.test.tictactoe.view.GameViewTerminal;

public class GameController {

    //TODO Dependency injection can be implemented here.
    Game game = new Game();
    GameView gameView = new GameViewTerminal();

    public GameController(){
        this.game.setGameView(gameView);
    }

    public void start(){
        this.game.start();
    }
    
}
