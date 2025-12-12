package snakeAndLadder;

import snakeAndLadder.controller.BoardController;
import snakeAndLadder.controller.GameController;
import snakeAndLadder.controller.PlayerController;
import snakeAndLadder.entities.Board;
import snakeAndLadder.entities.Player;
import snakeAndLadder.strategy.DiceStrategy;
import snakeAndLadder.strategy.NormalDice;

public class Demo {
    public static void main(String[] args){
        GameController controller = new GameController();
        BoardController boardController = new BoardController();
        PlayerController playerController = new PlayerController();
        DiceStrategy diceStrategy = new NormalDice();

        Board board = boardController.createBoard(10,10);
        boardController.addSnake(board, 17, 7);
        boardController.addSnake(board, 90, 50);
        boardController.addLadder(board, 4, 20);
        boardController.addLadder(board, 15, 75);

        Player player1=playerController.createPlayer("Shivam");
        Player player2= playerController.createPlayer("Aayush");

        controller.setBoard(board);
        controller.setDice(diceStrategy);
        controller.addPlayer(player1);
        controller.addPlayer(player2);
        controller.playGame();
    }
}
