package ticTacToe.state;

import ticTacToe.entities.GameContext;
import ticTacToe.entities.Player;
import ticTacToe.enums.Symbol;

public class XTurnState implements GameState{
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if(hasWon){
            context.setCurrentState(player.getSymbol() == Symbol.X ? new XWonState() : new OWinState());
        }
        else {
            context.setCurrentState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
