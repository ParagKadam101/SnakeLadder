package com.game.snakesAndLadder;

import com.game.snakesAndLadder.Dice.NormalDice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private final Player player = new Player();
    private final Board board = new Board(100, player, new NormalDice());

    @Test
    void shouldThrowExceptionWhenCreatingBoardWithInvalidSize() {
        assertThrows(IllegalArgumentException.class, () -> new Board(50, new Player(), new NormalDice()));
    }

    @Test
    void shouldBeAbleToAddSnakeToTheBoard() {
        Snake snake = new Snake(14, 5);
        board.addSnake(snake);
        assertEquals(1, board.getSnakes().size());
    }

    @Test
    void shouldThrowExceptionWhenAddingNewSnakeToTheBoardWhenExistingSnakePresentAtSamePosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            Snake snake = new Snake(14, 5);
            board.addSnake(snake);
            snake = new Snake(14, 8);
            board.addSnake(snake);
        });
    }

    @Test
    void playerShouldMoveToForwardPositionWhenNotGulpedBySnake() {
        player.rollDice();
        assertTrue(player.getPosition() > 1);
    }
}