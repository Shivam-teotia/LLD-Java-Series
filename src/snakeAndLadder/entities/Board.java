package snakeAndLadder.entities;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int row;
    private final int col;
    private final List<Snake> snakes=new ArrayList<>();
    private final List<Ladder> ladders=new ArrayList<>();

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getSize(){
        return row * col;
    }
}
