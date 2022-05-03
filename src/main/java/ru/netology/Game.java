package ru.netology;

import java.util.ArrayList;
import java.util.List;

import ru.netology.NotRegisteredException;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        this.players.add(player);
    }


    public int round(String playerName1, String playerName2) {
        var first = findByName(playerName1);
        var second = findByName(playerName2);
        if (first == null || second == null) {
            throw new NotRegisteredException();
        }
        var result = first.getStrength() - second.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }


    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }
}





