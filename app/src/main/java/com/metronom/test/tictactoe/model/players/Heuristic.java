package com.metronom.test.tictactoe.model.players;

import com.metronom.test.tictactoe.model.Board;
import com.metronom.test.tictactoe.model.Move;
import com.metronom.test.tictactoe.model.players.HumanPlayer;

public interface Heuristic {

    Move calculateMove(Board board);
}
