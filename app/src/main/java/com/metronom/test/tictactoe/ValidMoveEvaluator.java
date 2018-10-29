package com.metronom.test.tictactoe;

import com.metronom.test.tictactoe.domain.Board;
import com.metronom.test.tictactoe.domain.Move;
import com.metronom.test.tictactoe.domain.Player;

public class ValidMoveEvaluator {

    private Board board;

    public ValidMoveEvaluator(Board board){
        this.board = board;
    }

    public MoveType evaluateMove(Move move) {

        MoveType result = MoveType.OK;

        int size = board.getSize();

        if(move.col >= size || move.row >= size)
            result = MoveType.OUT_OF_BOUNDARIES;
        else if(board.getBoxValue(move.col, move.row) != 0){
            result = MoveType.BOX_TAKEN;
        }
        return result;
    }
}
