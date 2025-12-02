package ticTacToe.listener;

import ticTacToe.entities.Position;
import ticTacToe.enums.Symbol;
import ticTacToe.state.GameState;

public interface GameEventListener {
    void onMoveMade(Position position, Symbol symbol);
    void onGameStateChanged(GameState state);
}
