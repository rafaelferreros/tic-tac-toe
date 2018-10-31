package com.metronom.test.tictactoe.model;

import com.metronom.test.tictactoe.configuration.Configuration;
import com.metronom.test.tictactoe.model.players.ComputerPlayer;
import com.metronom.test.tictactoe.model.players.HumanPlayer;
import com.metronom.test.tictactoe.model.players.Player;
import com.metronom.test.tictactoe.model.rules.MoveType;
import com.metronom.test.tictactoe.model.rules.ValidMoveEvaluator;
import com.metronom.test.tictactoe.model.rules.WinEvaluator;
import com.metronom.test.tictactoe.model.players.Heuristic;
import com.metronom.test.tictactoe.configuration.ConfigurationException;
import com.metronom.test.tictactoe.configuration.ConfigurationLoader;
import com.metronom.test.tictactoe.view.GameView;
import com.metronom.test.tictactoe.view.GameViewTerminal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {

    private Configuration configuration = null;
    private boolean finished;
    private Board board;
    private List<Player> playerList = new ArrayList<Player>();
    private Iterator<Player> playerIterator;
    private Player currentPlayer;
    private Player winner;

    //TODO implement this as a Listener
    private GameView gameView;

    public Game(){

    }

    public void start(){
        setup();
        addPlayers();
        defineFirstPlayer();
        startGame();
    }

    private void startGame() {

        while(!isFinished()){
            gameView.show(getBoard());

            if(getCurrentPlayer() instanceof Heuristic){
                Heuristic heuristic = (Heuristic) getCurrentPlayer();
                Move move = heuristic.calculateMove(getBoard());
                gameView.autoPlay(getCurrentPlayer());
                this.play(move.col, move.row);
            }
            else{
                Move move = gameView.playTurn(getCurrentPlayer());
                this.play(move.col,move.row);
            }
        }

        gameView.show(getBoard());

        if(getWinner() != null){
            gameView.showWinner(getWinner());
        }

        gameView.showGameFinished();
        boolean resp = gameView.askAnotherGame();
        if(resp)
            this.start();
    }

    private void setup(){
        loadConfiguration();
        board = new Board(configuration.boardSize);
        this.finished = false;
        currentPlayer = null;
        winner = null;
    }

    private void loadConfiguration(){
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        try {
            this.configuration = configurationLoader.load();
        } catch (ConfigurationException e) {
            gameView.showError(e.getMessage());
            System.exit(1);
        }
    }

    private void addPlayers(){
        //TODO configure players
        playerList.add(new HumanPlayer(configuration.player1Char, "Player1"));
        //playerList.add(new HumanPlayer(configuration.player2Char, "Player2"));
        //playerList.add(new ComputerPlayer(configuration.player3Char, "Computer"));

    }

    private void defineFirstPlayer(){
        if(!playerList.isEmpty()){

            int  n =(int) (Math.random() * playerList.size());
            this.playerIterator = playerList.listIterator(n);
            if(this.playerIterator.hasNext())
                this.currentPlayer = this.playerIterator.next();
        }
    }

    public boolean play(int col, int row){

        Move move = new Move();
        move.player = this.currentPlayer;
        move.row = row;
        move.col = col;

        if(validMove(move)){
            board.setMove(move);

            if(isWinner(move)){
                this.winner = this.currentPlayer;
                this.finished = true;
            }
            else if (!movesAvailable()){
                this.finished = true;
            }
            else{
                this.currentPlayer = getNextPlayer();
            }
            return true;
        }
        else{
            this.gameView.showError("Invalid move, try again");
            return false;
        }
    }

    private boolean isWinner(Move move){
        WinEvaluator evaluator = new WinEvaluator(this.board);
        return evaluator.evaluateWin(move);
    }

    private boolean validMove(Move move){
        ValidMoveEvaluator eval = new ValidMoveEvaluator(this.board);
        MoveType result = eval.evaluateMove(move);
        //TODO send all the types of invalid moves to the interface
        return result == MoveType.OK;
    }

    private boolean movesAvailable(){
        return board.getAvailableBoxes() > 0;
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

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }
}
