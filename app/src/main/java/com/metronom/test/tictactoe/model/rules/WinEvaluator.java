package com.metronom.test.tictactoe.model.rules;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;

public class WinEvaluator {

    private Board board;

    public WinEvaluator(Board board){
        this.board = board;
    }

    public boolean evaluateWin(){
        Move lastMove = board.getLastMove();
        if(lastMove == null){
            return false;
        }

        return winColumn(lastMove) ||
               winRow(lastMove) ||
               winDiagonal1(lastMove) ||
               winDiagonal2(lastMove);

    }

    protected boolean winColumn(Move move){
        int col = move.col;

        for(int row = 0; row < this.board.getSize(); row++){
            if(board.getBoxValue(col,row) != move.player.getValue()){
                return false;
            }
        }
        return true;
    }

    protected boolean winRow(Move move){
        int row = move.row;

        for(int col = 0; col < this.board.getSize(); col++){
            if(board.getBoxValue(col,row) != move.player.getValue()){
                return false;
            }
        }
        return true;
    }

    protected boolean winDiagonal1( Move move){
        if(move.col != move.row) {
            return false;
        }
        else{
            for(int i = 0; i < this.board.getSize(); i++){
                if(board.getBoxValue(i,i) != move.player.getValue()){
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean winDiagonal2(Move move){
        int size = this.board.getSize();

        for(int i =0; i < size; i++){
            if(board.getBoxValue(size-1-i,i) != move.player.getValue()){
                return false;
            }
        }

        return true;
    }
}
