package com.game.snakesAndLadder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserAcceptanceTests {
    private final Player player = new Player();

    @Test
    void playerShouldMoveFromInitialPositionToNextByTheNumberOnTheDice() {
        given().playerPositionIs(21)
                .whenI().rollDiceBy(4)
                .thenI().reachAtPosition(25);
    }

    private UserAcceptanceTests playerPositionIs(int position) {
        player.moveByPosition(position-1);
        return this;
    }

    private UserAcceptanceTests given() {
        return this;
    }

    private void reachAtPosition(int position) {
        assertEquals(position, player.getPosition());
    }

    private UserAcceptanceTests thenI() {
        return this;
    }

    private UserAcceptanceTests rollDiceBy(int numberOnDice) {
        Player playerMock = mock(Player.class);
        when(playerMock.rollDice()).thenReturn(numberOnDice);
        int diceNumber = playerMock.rollDice();
        player.moveByPosition(diceNumber);
        return this;
    }

    private UserAcceptanceTests whenI() {
        return this;
    }
}
