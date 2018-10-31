package com.metronom.test.tictactoe.model.rules;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;

public class ValidMoveEvaluator {

    private Board board;

    public ValidMoveEvaluator(Board board){
        this.board = board;
    }

    public MoveType evaluateMove(Move move) {

        MoveType result = MoveType.OK;

        int size = board.getSize();

        if(move.col >= size || move.row >= size){
            result = MoveType.OUT_OF_BOUNDARIES;
        }
        else if (move.col < 0 || move.row < 0){
            result = MoveType.OUT_OF_BOUNDARIES;
        }
        else if(board.getBoxValue(move.col, move.row) != 0){
            result = MoveType.BOX_TAKEN;
        }
        return result;
    }
}
