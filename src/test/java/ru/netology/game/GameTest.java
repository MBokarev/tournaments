package ru.netology.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player first = new Player(1, "firstPlayer", 10);
    private Player second = new Player(2, "secondPlayer", 20);
    private Player third = new Player(3, "thirdPlayer", 30);
    private Player forth = new Player(4, "forthPlayer", 30);
    private Player fifth = new Player(5, "fifthPlayer", 1);

    @BeforeEach
    void registeredPlayers() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(forth);
    }

    @Test
    void shouldThrowExceptionWithSecondPlayerNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round(first.getName(), fifth.getName());
        });
    }

    @Test
    void shouldThrowExceptionWithFirstPlayerNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round(fifth.getName(), third.getName());
        });
    }

    @Test
    void shouldBeADraw() {
        int actual = game.round(forth.getName(), third.getName());
        assertEquals(0, actual);
    }

    @Test
    void firstPlayerMustWin() {
        int actual = game.round(third.getName(), "firstPlayer");
        assertEquals(1, actual);
    }

    @Test
    void secondPlayerMustWin() {
        int actual = game.round(first.getName(), second.getName());
        assertEquals(2, actual);
    }

    @Test
    void shouldShowAllRegisteredPlayers() {
        List<Player> expected = List.of(new Player[]{first, second, third, forth});
        List<Player> actual = game.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemovedRegisteredPlayerById() {
        game.remove(1);

        List<Player> expected = List.of(new Player[]{second,third,forth});
        List<Player> actual = game.findAll();

        assertEquals(expected, actual);
    }
}