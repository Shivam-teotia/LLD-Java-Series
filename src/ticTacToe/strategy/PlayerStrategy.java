package ticTacToe.strategy;

import ticTacToe.entities.Board;
import ticTacToe.entities.Position;

public interface PlayerStrategy {
    Position makeMove(Board board);
}
