package ticTacToe.entities;

import ticTacToe.enums.Symbol;

public class Board {
    private final int rows;
    private final int cols;
    private Symbol[][] grid;

    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        grid = new Symbol[rows][cols];
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols ;j++){
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < rows && pos.getCol() >= 0 && pos.getCol() < cols
                && grid[pos.getRow()][pos.getCol()] == Symbol.EMPTY;
    }

    public void makeMove(Position position, Symbol symbol){
        grid[position.getRow()][position.getCol()] = symbol;
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
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])) {
                context.next(context.getCurrentPlayer(), true);
                return;
            }
        }
        for (int i = 0; i < cols; i++) {
            Symbol[] column = new Symbol[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbol.EMPTY && isWinningLine(column)) {
                context.next(context.getCurrentPlayer(), true);
                return;
            }
        }
        Symbol[] diagonal1 = new Symbol[Math.min(rows, cols)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, cols)];
        for (int i = 0; i < Math.min(rows, cols); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][cols - 1 - i];
        }
        if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            context.next(context.getCurrentPlayer(), true);
            return;
        }
        if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            context.next(context.getCurrentPlayer(), true);
            return;
        }
        // Additional logic to handle a draw or continue in progress can be added
        // here
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
