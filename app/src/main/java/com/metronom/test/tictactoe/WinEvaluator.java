package com.metronom.test.tictactoe;

import com.metronom.test.tictactoe.domain.Board;
import com.metronom.test.tictactoe.domain.Move;

public class WinEvaluator {

    Board board;

    public WinEvaluator(Board board){
        this.board = board;
    }

    private boolean evaluateWin(Move move){

        return winColumn(move) ||
               winRow(move) ||
               winDiagonal1(move) ||
               winDiagonal2(move);

    }

    private boolean winColumn(Move move){return false;}
    private boolean winRow(Move move){return false;}
    private boolean winDiagonal1( Move move){return false;}
    private boolean winDiagonal2(Move move){return false;}
}
