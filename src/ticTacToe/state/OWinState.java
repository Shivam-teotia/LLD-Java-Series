package ticTacToe.state;

import ticTacToe.entities.GameContext;
import ticTacToe.entities.Player;

public class OWinState implements GameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        // Game over, no next state
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}