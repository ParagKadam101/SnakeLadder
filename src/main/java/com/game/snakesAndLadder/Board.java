package com.game.snakesAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private final List<Snake> snakes = new ArrayList<>();
    private final Player player;

    public Board(int size, Player player) {
        validateSize(size);
        this.player = player;
        this.player.setBoard(this);
    }

    private void validateSize(int size) {
        double dimension = Math.sqrt(size);
        if(dimension - Math.floor(dimension) != 0)
            throw new IllegalArgumentException("Invalid board size");
    }

    public void addSnake(Snake snake) {
        boolean snakeExistAtPosition = snakes.stream()
                .anyMatch(snake1 -> snake1.getSnakeStartPosition() == snake.getSnakeStartPosition());
        if(snakeExistAtPosition)
            throw new IllegalArgumentException("A snake already exists at given position");
        snakes.add(snake);
    }

    public void diceRolled(int diceNumber) {
        player.moveByPosition(diceNumber);
        determineNextPosition();
    }

    private void determineNextPosition() {
        Optional<Snake> snakeMaybe = snakes.stream()
                .filter(snake -> snake.getSnakeStartPosition() == player.getPosition())
                .findFirst();

        if(snakeMaybe.isPresent()) {
            Snake snake = snakeMaybe.get();
            player.moveByPosition(snake.getSnakeEndPosition() - snake.getSnakeStartPosition());
        }
    }
}
