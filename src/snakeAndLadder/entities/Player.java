package snakeAndLadder.entities;

public class Player {
    private final String name;
    private int position;

    public Player(String name, int position){
        this.name = name;
        this.position= position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }
}
