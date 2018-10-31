package com.metronom.test.tictactoe.model.ai;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.players.Player;

public class BasicRobot {


    public Move playFirstEmptyBox(Board board, Player player){

        Move move = new Move();
        move.player = player;
        for(int i=0; i< board.getSize(); i++)
            for(int j =0; j<board.getSize(); j++)
                if(board.getBoxValue(j,i) == 0){
                    move.col = j;
                    move.row = i;
                    return move;
                }

        return null;
    }

}
