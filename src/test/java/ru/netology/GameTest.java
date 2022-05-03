package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player firstGamer = new Player(1, "Ivan", 10);
    private Player secondGamer = new Player(2, "Petr", 20);
    private Player thirdGamer = new Player(3, "Oleg", 30);
    private Player fourthGamer = new Player(4, "Stepan", 30);
    private Player fifthGamer = new Player(5, "Nikolay", 25);


    @BeforeEach
    void setApp() {
        game.register(firstGamer);
        game.register(secondGamer);
        game.register(thirdGamer);
        game.register(fourthGamer);
    }

    @Test
    void shouldWinFirstPlayer() {
        int actual = game.round(thirdGamer.getName(), secondGamer.getName());
        assertEquals(1, actual);
    }

    @Test
    void shouldWinSecondPlayer() {
        int actual = game.round(firstGamer.getName(), thirdGamer.getName());
        assertEquals(2, actual);
    }

    @Test
    void shouldDraw() {
        int actual = game.round(thirdGamer.getName(), fourthGamer.getName());
        assertEquals(0, actual);
    }

    @Test
    void shouldThrowException() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(thirdGamer.getName(), fifthGamer.getName()));
    }

    @Test
    void shouldThrowExceptionFirst() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(fifthGamer.getName(), firstGamer.getName()));
    }

}