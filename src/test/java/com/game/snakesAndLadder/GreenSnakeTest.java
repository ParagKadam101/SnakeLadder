package com.game.snakesAndLadder;

import com.game.snakesAndLadder.Dice.NormalDice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreenSnakeTest {
    Player player = new Player();
    private final Board board = new Board(100, player, new NormalDice());

    @Test
    void greenSnakeShouldBiteAPlayerJustOnce() {
        given().greenSnake(55, 25).and().movePlayerBy(52)
                .whenI().rollDiceBy(3)
                .thenI().reachAtPosition(25);

        movePlayerBy(29).and().rollDiceBy(2)
                .thenI().reachAtPosition(55);
    }

    private void reachAtPosition(int position) {
        assertEquals(position, player.getPosition());
    }

    private GreenSnakeTest thenI() {
        return this;
    }

    private GreenSnakeTest rollDiceBy(int position) {
        board.diceRolled(position);
        return this;
    }

    private GreenSnakeTest whenI() {
        return this;
    }

    private GreenSnakeTest movePlayerBy(int position) {
        player.moveByPosition(position-1);
        return this;
    }

    private GreenSnakeTest and() {
        return this;
    }

    private GreenSnakeTest greenSnake(int startPosition, int endPosition) {
        Snake greenSnake = new GreenSnake(startPosition, endPosition);
        board.addSnake(greenSnake);
        return this;
    }

    private GreenSnakeTest given() {
        return this;
    }
}
