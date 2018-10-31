package com.metronom.test.tictactoe.model.rules;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.players.Player;
import org.junit.Assert;
import org.junit.Test;

public class WinEvaluatorTest {

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
    public void evaluateWin_false_one_move_test(){
        Move move = new Move();
        move.row = 0;
        move.col = 0;
        move.player = player;

        Board board = new Board(3);
        board.setMove(move);

        WinEvaluator evaluator = new WinEvaluator(board);

        boolean result = evaluator.evaluateWin();

        Assert.assertTrue("Result should be false", !result);
    }

    @Test
    public void evaluateWin_false_cero_move_test(){

        Board board = new Board(3);
        WinEvaluator evaluator = new WinEvaluator(board);

        boolean result = evaluator.evaluateWin();

        Assert.assertTrue("Result should be false", !result);
    }

    @Test
    public void evaluateWin_column1_true_test(){

        Move move = new Move();
        move.row = 0;
        move.col = 0;
        move.player = player;

        Board board = new Board(3);
        board.setMove(move);

        move.row = 1;
        move.col = 0;

        board.setMove(move);

        move.row = 2;
        move.col = 0;

        board.setMove(move);

        WinEvaluator evaluator = new WinEvaluator(board);

        boolean result = evaluator.evaluateWin();

        Assert.assertTrue("Result should be true", result);
    }

    @Test
    public void evaluateWin_row1_true_test(){

        Move move = new Move();
        move.row = 0;
        move.col = 0;
        move.player = player;

        Board board = new Board(3);
        board.setMove(move);

        move.row = 0;
        move.col = 1;

        board.setMove(move);

        move.row = 0;
        move.col = 2;

        board.setMove(move);

        WinEvaluator evaluator = new WinEvaluator(board);

        boolean result = evaluator.evaluateWin();

        Assert.assertTrue("Result should be true", result);
    }


    @Test
    public void evaluateWin_diagonal1_true_test(){

        Move move = new Move();
        move.row = 0;
        move.col = 0;
        move.player = player;

        Board board = new Board(3);
        board.setMove(move);

        move.row = 1;
        move.col = 1;

        board.setMove(move);

        move.row = 2;
        move.col = 2;

        board.setMove(move);

        WinEvaluator evaluator = new WinEvaluator(board);

        boolean result = evaluator.evaluateWin();

        Assert.assertTrue("Result should be true", result);
    }

    @Test
    public void evaluateWin_diagonal2_true_test(){

        Move move = new Move();
        move.row = 0;
        move.col = 2;
        move.player = player;

        Board board = new Board(3);
        board.setMove(move);

        move.row = 1;
        move.col = 1;

        board.setMove(move);

        move.row = 2;
        move.col = 0;

        board.setMove(move);

        WinEvaluator evaluator = new WinEvaluator(board);

        boolean result = evaluator.evaluateWin();

        Assert.assertTrue("Result should be true", result);
    }


}
