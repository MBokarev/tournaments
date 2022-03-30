package ru.netology.game;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    private Player findPlayers(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void remove(int id) {
        int length = players.size() - 1;
        Player[] tmp = new Player[length];
        int index = 0;
        for (Player player : players) {
            if (player.getId() != id) {
                tmp[index] = player;
                index++;
            }
        }
        players = List.of(tmp);
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        var first = findPlayers(playerName1);
        var second = findPlayers(playerName2);
        if (first == null || second == null) {
            throw new NotRegisteredException("One or both players not registered");
        }
        var result = first.getStrength() - second.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }

    public List<Player> findAll() {
        return players;
    }
}
