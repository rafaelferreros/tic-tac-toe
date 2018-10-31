package com.metronom.test.tictactoe.view;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.players.Player;

public interface GameView {

    void show(Board board);

    Move playTurn(Player player);

    void autoPlay(Player player);

    void showWinner(Player player);

    void showGameFinished();

    boolean askAnotherGame();

    void showError(String message);
}
