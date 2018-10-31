package com.metronom.test.tictactoe.model.rules;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.players.Player;
import org.junit.Assert;
import org.junit.Test;

public class ValidMoveEvaluatorTest {

    Player player = new Player() {
        @Override
        public String getName() {
            return "Test";
        }

        @Override
        public char getValue() {
            return 'X';
        }
    };

    @Test
    public void evaluateMove_valid_move_test(){

        Board board = new Board(3);
        ValidMoveEvaluator evaluator = new ValidMoveEvaluator(board);

        Move move = new Move();
        move.player = this.player;
        move.row = 0;
        move.col = 0;

        MoveType result = evaluator.evaluateMove(move);
        Assert.assertTrue("Move should be Ok", result.equals(MoveType.OK));
    }

    @Test
    public void evaluateMove_out_of_boundaries1_test(){

        Board board = new Board(3);
        ValidMoveEvaluator evaluator = new ValidMoveEvaluator(board);

        Move move = new Move();
        move.player = this.player;
        move.row = -1;
        move.col = 0;

        MoveType result = evaluator.evaluateMove(move);
        Assert.assertTrue("Move should be OUT_OF_BOUNDARIES", result.equals(MoveType.OUT_OF_BOUNDARIES));
    }

    @Test
    public void evaluateMove_out_of_boundaries2_test(){

        Board board = new Board(3);
        ValidMoveEvaluator evaluator = new ValidMoveEvaluator(board);

        Move move = new Move();
        move.player = this.player;
        move.row = 0;
        move.col = -1;

        MoveType result = evaluator.evaluateMove(move);
        Assert.assertTrue("Move should be OUT_OF_BOUNDARIES", result.equals(MoveType.OUT_OF_BOUNDARIES));
    }


    @Test
    public void evaluateMove_out_of_boundaries3_test(){

        Board board = new Board(3);
        ValidMoveEvaluator evaluator = new ValidMoveEvaluator(board);

        Move move = new Move();
        move.player = this.player;
        move.row = 4;
        move.col = 0;

        MoveType result = evaluator.evaluateMove(move);
        Assert.assertTrue("Move should be OUT_OF_BOUNDARIES", result.equals(MoveType.OUT_OF_BOUNDARIES));
    }

    @Test
    public void evaluateMove_out_of_boundaries4_test(){

        Board board = new Board(3);
        ValidMoveEvaluator evaluator = new ValidMoveEvaluator(board);

        Move move = new Move();
        move.player = this.player;
        move.row = 0;
        move.col = 4;

        MoveType result = evaluator.evaluateMove(move);
        Assert.assertTrue("Move should be OUT_OF_BOUNDARIES", result.equals(MoveType.OUT_OF_BOUNDARIES));
    }

    @Test
    public void evaluateMove_box_taken_test(){

        Board board = new Board(3);
        ValidMoveEvaluator evaluator = new ValidMoveEvaluator(board);

        Move move = new Move();
        move.player = this.player;
        move.row = 0;
        move.col = 0;

        board.setMove(move);

        MoveType result = evaluator.evaluateMove(move);
        Assert.assertTrue("Move should be BOX_TAKEN", result.equals(MoveType.BOX_TAKEN));
    }



}
