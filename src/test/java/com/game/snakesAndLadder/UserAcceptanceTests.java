package com.game.snakesAndLadder;

import com.game.snakesAndLadder.Dice.CrookedDice;
import com.game.snakesAndLadder.Dice.NormalDice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAcceptanceTests {
    private static final int BOARD_SIZE = 100;
    private final Player player = new Player();
    private final Dice dice = new NormalDice();
    private Board board = new Board(BOARD_SIZE, player, dice);

    @Test
    void playerShouldMoveFromInitialPositionToNextByTheNumberOnTheDice() {
        given().playerPositionIs(21)
                .whenI().rollDiceBy(4)
                .thenI().reachAtPosition(25);
    }

    @Test
    void snakeShouldMovePlayerFromItsStartToEndPosition() {
        given().snakePositionIs(14,7).and().playerPositionIs(12)
                .whenI().rollDiceBy(2)
                .thenI().reachAtPosition(7);
    }

    @Test
    void gameCanBeInitiatedWithAnyDice() {
        whenI().useDiceType(new NormalDice()).thenI().verifyDiceWorks();
        whenI().useDiceType(new CrookedDice()).thenI().verifyDiceWorks();
    }

    private void verifyDiceWorks() {
        assertDoesNotThrow(player::rollDice);
    }

    private UserAcceptanceTests useDiceType(Dice dice) {
        board = new Board(BOARD_SIZE, player, dice);
        return this;
    }

    private UserAcceptanceTests and() {
        return this;
    }

    private UserAcceptanceTests snakePositionIs(int snakeStartPosition, int snakeEndPosition) {
        Snake snake = new Snake(snakeStartPosition, snakeEndPosition);
        board.addSnake(snake);
        return this;
    }

    private UserAcceptanceTests playerPositionIs(int position) {
        player.moveByPosition(position-1);
        return this;
    }

    private UserAcceptanceTests given() {
        return this;
    }

    private void reachAtPosition(int position) {
        assertEquals(position, player.getPosition());
    }

    private UserAcceptanceTests thenI() {
        return this;
    }

    private UserAcceptanceTests rollDiceBy(int diceNumber) {
        board.diceRolled(diceNumber);
        return this;
    }

    private UserAcceptanceTests whenI() {
        return this;
    }
}
