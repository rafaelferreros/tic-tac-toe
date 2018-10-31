package com.metronom.test.tictactoe.model;

public class Board {

    private int size;
    private char[][] playBoard;
    private int availableBoxes;
    private Move lastMove;

    public Board(int size){
        this.size = size;
        this.availableBoxes = size * size;
        this.playBoard = new char[size][size];
    }

    public int getSize() {
        return size;
    }

    public char getBoxValue(int col, int row){
        return playBoard[col][row];
    }

    public void setMove(Move move){
        if(playBoard[move.col][move.row] == 0){
            availableBoxes--;
        }
        playBoard[move.col][move.row] = move.player.getValue();
        lastMove = move;
    }

    public int getAvailableBoxes(){
        return availableBoxes;
    }

    public Move getLastMove(){
        return lastMove;
    }


}
