package ticTacToe.entities;

import ticTacToe.enums.Symbol;
import ticTacToe.strategy.PlayerStrategy;

public class Player {
    Symbol symbol;
    PlayerStrategy playerStrategy;

    public Player(Symbol symbol, PlayerStrategy playerStrategy){
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    public PlayerStrategy getPlayerStrategy(){
        return this.playerStrategy;
    }
}
