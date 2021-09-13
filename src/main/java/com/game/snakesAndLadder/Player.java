package com.game.snakesAndLadder;

public class Player {

    private int position;

    public Player() {
        position = 1;
    }

    public int rollDice() {
        return Dice.roll();
    }

    public void moveByPosition(int position) {
        this.position += position;
    }

    public int getPosition() {
        return this.position;
    }
}
