package com.game.snakesAndLadder;

public class Snake {
    private final int snakeStartPosition;
    private final int snakeEndPosition;

    public Snake(int snakeStartPosition, int snakeEndPosition) {
        if(snakeStartPosition <= snakeEndPosition)
            throw new IllegalArgumentException("Invalid snake config");
        this.snakeStartPosition = snakeStartPosition;
        this.snakeEndPosition = snakeEndPosition;
    }

    public int getSnakeStartPosition() {
        return snakeStartPosition;
    }

    public int getSnakeEndPosition() {
        return snakeEndPosition;
    }
}
