package snakeAndLadder.services;

public class GameSession {
    public GameSession(String id) {
    }

    public GameSession createSession(String id){
        return new GameSession(id);
    }
}
