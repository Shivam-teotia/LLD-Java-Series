package ticTacToe;

import ticTacToe.strategy.HumanPlayerStrategy;
import ticTacToe.strategy.PlayerStrategy;

public class Main {
    public static void main(String[] args){
        PlayerStrategy playerXStrategy = new HumanPlayerStrategy("Player X");
        PlayerStrategy playerOStrategy = new HumanPlayerStrategy("Player O");
        TicTacToeGame game = new TicTacToeGame(playerXStrategy, playerOStrategy, 3, 3);
        game.play();
    }
}
