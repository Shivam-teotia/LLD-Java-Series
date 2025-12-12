package snakeAndLadder.services;

import snakeAndLadder.entities.Board;
import snakeAndLadder.entities.Ladder;
import snakeAndLadder.entities.Snake;

public class BoardService {

    public Board createBoard(int row, int col){
        return new Board(row,col);
    }

    public void addSnake(Board board, int head, int tail){
        board.getSnakes().add(new Snake(head,tail));
    }

    public void addLadder(Board board, int start, int end){
        board.getLadders().add(new Ladder(start,end));
    }
}
