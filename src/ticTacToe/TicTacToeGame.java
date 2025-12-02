package ticTacToe;

import ticTacToe.entities.Board;
import ticTacToe.entities.GameContext;
import ticTacToe.entities.Player;
import ticTacToe.entities.Position;
import ticTacToe.enums.Symbol;
import ticTacToe.listener.ConsoleGameEventListener;
import ticTacToe.state.GameState;
import ticTacToe.state.OWinState;
import ticTacToe.state.XWonState;
import ticTacToe.strategy.PlayerStrategy;

public class TicTacToeGame implements BoardGames{
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private final GameContext gameContext;
    private Player currentPlayer;


    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy oStrategy,
                         int rows, int columns) {
        board = new Board(rows, columns);
        board.addListener(new ConsoleGameEventListener());
        playerX = new Player(Symbol.X, xStrategy);
        playerO = new Player(Symbol.O, oStrategy);
        currentPlayer = playerX;
        gameContext = new GameContext(currentPlayer);
    }

    @Override
    public void play() {
        do{
            board.printBoard();
            Position move = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            board.checkGameState(gameContext);
            switchPlayer();
        }
        while (!gameContext.isGameOver());
            announceResult();
    }

    private void announceResult() {
        GameState state = gameContext.getCurrentState();
        if (state instanceof XWonState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWinState) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        gameContext.setCurrentPlayer(currentPlayer);

    }
}
