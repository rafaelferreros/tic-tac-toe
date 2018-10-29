package com.metronom.test.tictactoe.ui;

import com.metronom.test.tictactoe.Game;
import com.metronom.test.tictactoe.domain.Board;
import com.metronom.test.tictactoe.domain.Move;
import com.metronom.test.tictactoe.domain.Player;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BoardViewTerminal implements BoardView {

    public BoardViewTerminal(){

    }

    public void show(Board board) {

        int size = board.getSize();

        for(int row = 0; row < size; row++){
            printRow(row, board);
            printRowSeparator();
        }
    }

    private void printRow(int row, Board board){
        int size = board.getSize();
        for(int col = 0; col < size; col++){
            char value = board.getBoxValue(col, row);

            if(value == 0)
                value = ' ';

            if(col == size - 1) {
                System.out.print(value + "");
            }
            else{
                System.out.print(value + "|");
            }
        }
    }

    private void printRowSeparator(){
        System.out.println();

    }

    public void playTurn(Game game){

        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter column: ");
        int col = scanner.nextInt();

        System.out.print("Enter row: ");
        int row = scanner.nextInt();

        game.play(col, row);
    }

}
