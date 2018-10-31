package com.metronom.test.tictactoe.model.players;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.ai.BasicRobot;

public class ComputerPlayer implements Player, Heuristic {


    private BasicRobot basicRobot = new BasicRobot();
    private String name;
    private char value;

    public ComputerPlayer(char value, String name){
        this.value = value;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getValue() {
        return value;
    }

    @Override
    public Move calculateMove(Board board) {
       return basicRobot.playFirstEmptyBox(board, this);
    }
}
