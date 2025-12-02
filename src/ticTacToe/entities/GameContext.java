package ticTacToe.entities;

import ticTacToe.state.GameState;
import ticTacToe.state.XTurnState;

public class GameContext {
    private GameState currentState;
    private Player currentPlayer;
    public GameContext(Player player){
        currentState = new XTurnState();
        this.currentPlayer = player;
    }

    public GameState getCurrentState(){
        return this.currentState;
    }

    public void setCurrentPlayer(Player player){
        currentPlayer=player;
    }

    public void setCurrentState(GameState state){
        this.currentState = state;
    }

    public boolean isGameOver(){
        return currentState.isGameOver();
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void next(Player player, boolean hasWon){
        this.currentState.next(this, player, hasWon);
    }
}
