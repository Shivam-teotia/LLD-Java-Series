package ticTacToe.entities;

import ticTacToe.enums.Symbol;
import ticTacToe.listener.GameEventListener;
import ticTacToe.state.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int rows;
    private final int cols;
    private final Symbol[][] grid;
    private List<GameEventListener> listeners;

    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        listeners = new ArrayList<>();
        grid = new Symbol[rows][cols];
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols ;j++){
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public void addListener(GameEventListener listener) {
        listeners.add(listener);
    }

    public void notifyMoveMade(Position position, Symbol symbol) {
        for (GameEventListener listener : listeners) {
            listener.onMoveMade(position, symbol);
        }
    }
    // Notifies user on change of game state
    public void notifyGameStateChanged(GameState state) {
        for (GameEventListener listener : listeners) {
            listener.onGameStateChanged(state);
        }
    }

    public boolean isValidMove(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < rows && pos.getCol() >= 0 && pos.getCol() < cols
                && grid[pos.getRow()][pos.getCol()] == Symbol.EMPTY;
    }

    public void makeMove(Position position, Symbol symbol){
        grid[position.getRow()][position.getCol()] = symbol;
        notifyMoveMade(position, symbol);
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }
                if (j < cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public void checkGameState(GameContext context) {
        // Row and Column Win condition checks
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])) {
                GameState newState =
                        grid[i][0] == Symbol.X ? new XWonState() : new OWinState();
                context.setCurrentState(newState);
                notifyGameStateChanged(
                        newState); // Notify listeners when the game state changes
                return;
            }
        }
        for (int i = 0; i < cols; i++) {
            Symbol[] column = new Symbol[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbol.EMPTY && isWinningLine(column)) {
                GameState newState =
                        column[0] == Symbol.X ? new XWonState() : new OWinState();
                context.setCurrentState(newState);
                notifyGameStateChanged(
                        newState); // Notify listeners when the game state changes
                return;
            }
        }
        // Diagonal checks
        Symbol[] diagonal1 = new Symbol[Math.min(rows, cols)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, cols)];
        for (int i = 0; i < Math.min(rows, cols); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][cols - 1 - i];
        }
        if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            GameState newState =
                    diagonal1[0] == Symbol.X ? new XWonState() : new OWinState();
            context.setCurrentState(newState);
            notifyGameStateChanged(
                    newState); // Notify listeners when the game state changes
            return;
        }
        if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            GameState newState =
                    diagonal2[0] == Symbol.X ? new XWonState() : new OWinState();
            context.setCurrentState(newState);
            notifyGameStateChanged(
                    newState); // Notify listeners when the game state changes
            return;
        }
        // Draw check
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == Symbol.EMPTY) {
                    context.setCurrentState(new InProgressState());
                    return;
                }
            }
        }
        context.setCurrentState(new DrawState());
        notifyGameStateChanged(
                new DrawState()); // Notify listeners when the game state changes
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }
}
