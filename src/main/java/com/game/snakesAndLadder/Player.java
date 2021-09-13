package com.game.snakesAndLadder;

public class Player {

    private int position;
    private Board board;
    private int turn = 0;

    public Player() {
        position = 1;
    }

    public void rollDice() {
        if(turn == 10)
            throw new IllegalStateException("Player turns have exhausted!");
        int diceNumber = board.getDice().roll();
        board.diceRolled(diceNumber);
        turn++;
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
