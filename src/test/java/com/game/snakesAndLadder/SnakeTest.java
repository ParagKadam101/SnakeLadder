package com.game.snakesAndLadder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    @Test
    void shouldNotCreateSnakeHavingStartPositionGreaterThanEndPosition() {
        assertThrows(IllegalArgumentException.class, () -> new Snake(10, 30));
    }
}