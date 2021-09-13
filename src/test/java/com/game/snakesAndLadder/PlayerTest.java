package com.game.snakesAndLadder;

import com.game.snakesAndLadder.Dice.NormalDice;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
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
        Dice dice = mock(NormalDice.class);
        when(board.getDice()).thenReturn(dice);
        when(dice.roll()).thenReturn(2);
        player.setBoard(board);
        player.rollDice();
        verify(board, times(1)).diceRolled(2);
    }

    @Test
    void shouldNotAllowPlayerToRollDiceMoreThan10Times() {
        player.setBoard(new Board(100, player, new NormalDice()));
        assertDoesNotThrow(() -> IntStream.range(0, 10).forEach(itr -> player.rollDice()));
        assertThrows(IllegalStateException.class, () -> IntStream.range(0, 11).forEach(itr -> player.rollDice()));
    }
}