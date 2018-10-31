package com.metronom.test.tictactoe.model;

import com.metronom.test.tictactoe.model.players.Player;
import org.junit.Assert;
import org.junit.Test;

public class BoardTest {


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
    public void getAvailableBoxes_new_board_test(){
        int size = 3;
        Board board = new Board(size);
        Assert.assertTrue("Should be 9 available boxes", size *size == board.getAvailableBoxes());
    }

    @Test
    public void getAvailableBoxes_one_move_test(){
        int size = 3;
        Board board = new Board(size);

        Move move = new Move();
        move.row = 0;
        move.col = 0;
        move.player = player;

        board.setMove(move);

        Assert.assertTrue("Should be 8 available boxes", size*size-1 == board.getAvailableBoxes());
    }

}
