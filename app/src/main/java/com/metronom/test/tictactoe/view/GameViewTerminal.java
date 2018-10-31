package com.metronom.test.tictactoe.view;

import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameViewTerminal implements GameView {

    public GameViewTerminal(){

    }

    public void show(Board board) {
        System.out.println();

        int size = board.getSize();
        showHeader(size);
        for(int row = 0; row < size; row++){
            showRow(row, board);
            showRowSeparator();
        }
    }

    private void showHeader(int size) {
        System.out.print("Col:   ");
        for(int i = 0; i<size; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void showRow(int row, Board board){
        int size = board.getSize();
        if(row == 0 ){
            System.out.print("Row: "+row+" ");
        }
        else{
            System.out.print("     "+row+" ");
        }

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

    private void showRowSeparator(){
        System.out.println();
    }

    @Override
    public void showError(String message){
        System.out.println();
        System.out.println("---------- ERROR ----------");
        System.out.println(message);
        System.out.println("---------------------------");
    }

    @Override
    public Move playTurn(Player player){

        showPlayer(player);

        Scanner scanner = new Scanner(System.in);

        int col = 0;
        int row = 0;
        try{
            System.out.print("Enter column: ");
            col = scanner.nextInt();

            System.out.print("Enter row: ");
            row = scanner.nextInt();

        }catch (InputMismatchException e){
            showError("Not a number, try again");
            System.out.flush();
            playTurn(player);
        }

        Move move = new Move();
        move.row = row;
        move.col = col;
        move.player = player;

        return move;
    }

    @Override
    public void autoPlay(Player player){
        showPlayer(player);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press any key to continue: ");
        scanner.nextLine();

    }

    @Override
    public void showWinner(Player player) {
        System.out.println();
        System.out.println("--------   WINNER  --------");
        System.out.println("The winner is: " + player.getName() +" ("+ player.getValue()+")");
        System.out.println("---------------------------");
    }

    @Override
    public void showGameFinished() {
        System.out.println("-------- Game Over --------");
    }

    @Override
    public boolean askAnotherGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Another game? (y/n):");
        String resp = scanner.nextLine();

        return resp.toLowerCase().equals("y");
    }

    public void showPlayer(Player currentPlayer) {
        System.out.println();
        System.out.println("It's " + currentPlayer.getName() +" turn ("+ currentPlayer.getValue()+")");
    }

}
