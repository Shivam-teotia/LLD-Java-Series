package snakeAndLadder.strategy;

import java.util.Random;

public class EvenDigitDice implements DiceStrategy{
    private final Random random = new Random();
    @Override
    public int roll() {
        return (random.nextInt(3)+1)*2;
    }
}
