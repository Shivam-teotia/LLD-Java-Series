package snakeAndLadder.controller;

import snakeAndLadder.entities.Board;
import snakeAndLadder.entities.BoardJump;
import snakeAndLadder.entities.Player;
import snakeAndLadder.strategy.DiceStrategy;

import java.util.LinkedList;
import java.util.Queue;

public class GameController {
    private Board board;
    private DiceStrategy dice;
    private Queue<Player> players = new LinkedList<>();

    private Player currentPlayer;   // tracks who is playing right now

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setDice(DiceStrategy dice) {
        this.dice = dice;
    }

    public void addPlayer(Player player) {
        players.offer(player);
    }

    /**
     * Finds Snake/Ladder at a position
     */
    private int applyJumps(int position) {
        for (BoardJump j : board.getLadders()) {
            if (j.getStart() == position) {
                return j.getEnd();
            }
        }
        for (BoardJump j : board.getSnakes()) {
            if (j.getStart() == position) {
                return j.getEnd();
            }
        }
        return position;
    }

    /**
     * Handles the movement of the current player
     */
    private boolean moveCurrentPlayer() {
        int roll = dice.roll();
        System.out.println(currentPlayer.getName() + " rolled: " + roll);

        int oldPos = currentPlayer.getPosition();
        int newPos = oldPos + roll;

        if (newPos > board.getSize()) {
            System.out.println(currentPlayer.getName() + " cannot move (beyond board). Staying at " + oldPos);
            return false;
        }

        // apply snake or ladder
        int finalPos = applyJumps(newPos);

        currentPlayer.setPosition(finalPos);

        System.out.println(currentPlayer.getName() + " moved from " + oldPos +
                " to " + finalPos);

        if (finalPos == board.getSize()) {
            System.out.println("🎉 " + currentPlayer.getName() + " wins!");
            return true;
        }
        return false;
    }

    /**
     * Main play loop
     */
    public void playGame() {
        if (board == null || dice == null || players.size() < 2) {
            throw new IllegalStateException("Game setup incomplete!");
        }

        System.out.println("Game Started with " + players.size() + " players!");

        while (true) {

            // pick next player
            currentPlayer = players.poll();
            System.out.println("\nIt's " + currentPlayer.getName() + "'s turn.");

            // perform movement
            boolean hasWon = moveCurrentPlayer();
            if (hasWon) {
                break;
            }

            // push player back to queue
            players.offer(currentPlayer);
        }

        System.out.println("Game Over.");
    }
}
