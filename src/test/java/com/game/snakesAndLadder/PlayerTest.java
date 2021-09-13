package com.game.snakesAndLadder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    }
}