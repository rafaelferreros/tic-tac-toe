package com.metronom.test.tictactoe.ui;

import com.metronom.test.tictactoe.Game;
import com.metronom.test.tictactoe.domain.Board;

public interface BoardView {

    void show(Board board);

    void playTurn(Game game);
}
