package snakeAndLadder.entities;

public class Snake implements BoardJump{
    private final int head;
    private final int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public int getStart() {
        return head;
    }

    @Override
    public int getEnd() {
        return tail;
    }
}
