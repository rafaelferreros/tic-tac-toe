package com.metronom.test.tictactoe.model.ai;


import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.players.Player;
import org.junit.Assert;
import org.junit.Test;

public class BasicRobotTest {

    @Test
    public void playFirstEmptyBox_first_move_test(){
        BasicRobot basicRobot = new BasicRobot();

        Board board = new Board(3);
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
        Move move = basicRobot.playFirstEmptyBox(board, player);

        Assert.assertTrue("incorrect col", move.col == 0);
        Assert.assertTrue("incorrect row", move.row == 0);
        Assert.assertTrue("incorrect player", move.player.getValue() == player.getValue());
    }



    @Test
    public void playFirstEmptyBox_second_move_test(){
        BasicRobot basicRobot = new BasicRobot();

        Board board = new Board(3);

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
        Move move = new Move();
        move.col = 0;
        move.row = 0;
        move.player = player;
        board.setMove(move);

        Move moveResult = basicRobot.playFirstEmptyBox(board, player);

        Assert.assertTrue("incorrect col", moveResult.col == 1);
        Assert.assertTrue("incorrect row", moveResult.row == 0);
        Assert.assertTrue("incorrect player", moveResult.player.getValue() == player.getValue());
    }

}
