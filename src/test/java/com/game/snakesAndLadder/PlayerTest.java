package com.game.snakesAndLadder;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerTest {
    Player player = new Player();

    @Test
    void initialPositionOfPlayerIs1() {
        assertEquals(1, player.getPosition());
    }

    @Test
    void moveByPosition() {
        player.moveByPosition(5);
        assertEquals(6, player.getPosition());

        player.moveByPosition(-3);
        assertEquals(3, player.getPosition());
    }

    @Test
    void rollDice() {
        Board board = mock(Board.class);
        try(MockedStatic<Dice> dice = mockStatic(Dice.class)) {
            dice.when(Dice::roll).thenReturn(2);
            player.setBoard(board);
            player.rollDice();
            verify(board, times(1)).diceRolled(2);
        }
    }
}