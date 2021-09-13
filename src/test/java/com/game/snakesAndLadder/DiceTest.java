package com.game.snakesAndLadder;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {
    @RepeatedTest(100)
    void shouldGenerateRandomNumberOnlyBetween1And6() {
        int diceNumber = Dice.roll();
        assertTrue(diceNumber >= 1 && diceNumber <= 6);
    }
}