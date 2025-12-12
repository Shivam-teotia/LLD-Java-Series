package snakeAndLadder.controller;

import snakeAndLadder.entities.Board;
import snakeAndLadder.services.BoardService;

public class BoardController {
    private final BoardService boardService = new BoardService();

    public Board createBoard(int row,int col) {
        return boardService.createBoard(row, col);
    }

    public void addSnake(Board board, int head, int tail) {
        boardService.addSnake(board, head, tail);
    }

    public void addLadder(Board board, int start, int end) {
        boardService.addLadder(board, start, end);
    }
}
