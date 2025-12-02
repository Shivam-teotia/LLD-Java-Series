package ticTacToe.state;

import ticTacToe.entities.GameContext;
import ticTacToe.entities.Player;

public class DrawState implements GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
