package com.game.snakesAndLadder;

public class GreenSnake extends Snake {
    private boolean isBitten = false;

    public GreenSnake(int snakeStartPosition, int snakeEndPosition) {
        super(snakeStartPosition, snakeEndPosition);
    }

    public boolean isBitten() {
        return isBitten;
    }

    public void setBitten(boolean bitten) {
        isBitten = bitten;
    }
}
