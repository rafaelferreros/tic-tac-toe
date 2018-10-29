package com.metronom.test.tictactoe;

import com.metronom.test.tictactoe.domain.Board;
import com.metronom.test.tictactoe.domain.Move;
import com.metronom.test.tictactoe.domain.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {

    boolean started;
    boolean finished;
    int boardSize = 5;
    private Board board;
    List<Player> playerList = new ArrayList<Player>();
    List<String> rules = new ArrayList<String>();
    Iterator<Player> playerIterator;
    Player currentPlayer;
    Player winner;


    public Game(){
    }

    public void start(){
        setup();
        addPlayers();
        defineFirstPlayer();
        this.started = true;

    }

    private void setup(){
        board = new Board(boardSize);
        this.started = false;
        this.finished = false;
        currentPlayer = null;
        winner = null;
    }

    private void addPlayers(){
        playerList.add(new Player('X', true));
        playerList.add(new Player('O', true));
        playerList.add(new Player('M', true));
        this.playerIterator = playerList.iterator();
    }

    private void defineFirstPlayer(){
        if(!playerList.isEmpty()){
            this.currentPlayer = playerIterator.next();
        }
    }

    public boolean play(int col, int row){

        Move move = new Move();
        move.player = this.currentPlayer;
        move.row = row;
        move.col = col;

        if(validMove(move)){
            board.setMove(move);

            if(isWinner(move.player)){
                this.winner = move.player;
                this.finished = true;
            }
            else if (noMovesAvailable()){
                this.finished = true;
            }
            else{
                this.currentPlayer = getNextPlayer();
            }
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isWinner(Player player){
        return false;
    }

    private boolean validMove(Move move){
        ValidMoveEvaluator eval = new ValidMoveEvaluator(this.board);
        MoveType result = eval.evaluateMove(move);
        return result == MoveType.OK;
    }

    private boolean noMovesAvailable(){
        return false;
    }

    private Player getNextPlayer(){
        if(playerIterator.hasNext()){
            return playerIterator.next();
        }
        else{
            playerIterator = playerList.iterator();
            return playerIterator.next();
        }
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public Player getWinner(){
        return this.winner;
    }

    public boolean isFinished(){
        return this.finished;
    }

    public Board getBoard(){
        return this.board;
    }



}
