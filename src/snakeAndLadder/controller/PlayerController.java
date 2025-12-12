package snakeAndLadder.controller;

import snakeAndLadder.entities.Player;

public class PlayerController {
    public Player createPlayer(String name){
        return new Player(name,0);
    }
}
