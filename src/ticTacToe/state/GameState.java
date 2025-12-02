package ticTacToe.state;

import ticTacToe.entities.GameContext;
import ticTacToe.entities.Player;

public interface GameState {
    void next(GameContext context, Player player, boolean hasWon);
    boolean isGameOver();
}
