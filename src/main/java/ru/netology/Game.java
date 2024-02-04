package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    // Метод регистрации игрока и включения его в список игроков
    public void register(Player player) {
        players.add(player);
    }

    // Метод поиска игрока в списке игроков по его имени
    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    // Метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        for (Player player : players) { // перебираем всех игроков
            if (findByName(playerName1) == null) { // исключение по первому имени
                throw new NotRegisteredException("Player with name: " + playerName1 + " not registered");
            }
            if (findByName(playerName2) == null) { // исключение по второму имени
                throw new NotRegisteredException("Player with name: " + playerName2 + " not registered");
            }
            if (player1.getStrength() > player2.getStrength()) { // сила первого игрока больше силы второго
                return 1;
            }
            if (player1.getStrength() < player2.getStrength()) { // сила второго игрока больше силы первого
                return 2;
            }
        }
        return 0; // ничья
    }
}