package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Player player1 = new Player(01, "Иванов", 50);
    Player player2 = new Player(02, "Петров", 90);
    Player player3 = new Player(03, "Сидоров", 70);
    Player player4 = new Player(04, "Михайлов", 50);

    @Test
    public void shouldGetId() {
        Game game = new Game();
        int expected = 02;
        int actual = player2.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindDyName() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Player expected = player2;
        Player actual = game.findByName("Петров");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDontFindByName() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Player expected = null;
        Player actual = game.findByName("Алексеев");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionByName1() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Алексеев", "Сидоров");
        });
    }

    @Test
    public void shouldThrowExceptionByName2() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Иванов", "Алексеев");
        });
    }

    @Test
    public void shouldWinPlayer1() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int expected = 1;
        int actual = game.round("Петров", "Сидоров");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int expected = 2;
        int actual = game.round("Иванов", "Сидоров");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int expected = 0;
        int actual = game.round("Иванов", "Михайлов");
        Assertions.assertEquals(expected, actual);
    }
}