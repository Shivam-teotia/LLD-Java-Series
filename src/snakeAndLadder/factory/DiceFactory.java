package snakeAndLadder.factory;

import snakeAndLadder.strategy.DiceStrategy;
import snakeAndLadder.strategy.EvenDigitDice;
import snakeAndLadder.strategy.NormalDice;

public class DiceFactory {
    public static DiceStrategy getDice(String type){
        return switch (type){
            case "NORMAL" -> new NormalDice();
            case "CROOKED" -> new EvenDigitDice();
            default -> throw new IllegalArgumentException("Invalid Dice Type");
        };
    }
}
