package com.game.snakesAndLadder;

public class Player {

    private int position;
    private Board board;

    public Player() {
        position = 1;
    }

    public void rollDice() {
        int diceNumber = Dice.roll();
        board.diceRolled(diceNumber);
    }

    public void moveByPosition(int moveBy) {
        this.position += moveBy;
    }

    public int getPosition() {
        return this.position;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
