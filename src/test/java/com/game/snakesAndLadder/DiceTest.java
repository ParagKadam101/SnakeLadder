package com.game.snakesAndLadder;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {
    @RepeatedTest(100)
    void shouldGenerateRandomNumberOnlyBetween1And6ForNormalDice() {
        int diceNumber = new Dice.NormalDice().roll();
        assertTrue(diceNumber >= 1 && diceNumber <= 6);
    }

    @RepeatedTest(100)
    void shouldGenerateRandomEvenNumberOnlyBetween1And6ForCrookedDice() {
        int diceNumber = new Dice.CrookedDice().roll();
        assertTrue(diceNumber == 2 || diceNumber == 4 || diceNumber == 6);
    }
}