package com.metronom.test.tictactoe.controller;

import com.metronom.test.tictactoe.Game;
import com.metronom.test.tictactoe.ui.BoardView;

public class BoardController {

    BoardView boardView;
    Game game;

    public BoardController(Game game, BoardView boardView){
        this.game = game;
        this.boardView = boardView;
    }

    public void play(int col, int row){

        game.play(col, row);
    }

    public void showBoard(){
        this.boardView.show(game.getBoard());
    }




}
