package com.game.snakesAndLadder;

import java.util.List;
import java.util.Random;

public interface Dice {
    int roll();

    class CrookedDice implements Dice {
        @Override
        public int roll() {
            Random random = new Random();
            return List.of(2, 4, 6).get(random.nextInt(3));
        }
    }

    class NormalDice implements Dice {
        @Override
        public int roll() {
            return (int)(Math.random() * 6 + 1);
        }
    }
}
