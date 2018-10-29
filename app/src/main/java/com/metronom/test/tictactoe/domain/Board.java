package com.metronom.test.tictactoe.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Player> players = new ArrayList<Player>();
    private int size;
    private char[][] playBoard;

    public Board(int size){
        this.size = size;
        this.playBoard = new char[size][size];
    }

    public int getSize() {
        return size;
    }

    public char getBoxValue(int col, int row){
        return playBoard[col][row];
    }

    public void setMove(Move move){
        playBoard[move.col][move.row] = move.player.getValue();
    }

    public char[][] getPlayBoard(){
        return playBoard.clone();
    }

}
