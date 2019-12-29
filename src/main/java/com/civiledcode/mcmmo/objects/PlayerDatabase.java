package com.civiledcode.mcmmo.objects;

import cn.nukkit.Player;
import com.civiledcode.mcmmo.Main;

import java.sql.SQLException;

public class PlayerDatabase {

    private Player player;

    public PlayerDatabase(Player player) {
        this.player = player;
    }

    public String TYPE_MINE = "Mine";
    public String TYPE_MOBS = "Entities";
    public String TYPE_PLAYERS = "Players";
    public String TYPE_FARMING = "Farming";

    public int getExperience(String type) {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experience" + type + "FROM players WHERE name='" + player.getName() + "'").getInt("experience" + type);
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setExperience(int Experience, String type) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experience" + type + "=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getLevel(String type) {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT level" + type + "FROM players WHERE name='" + player.getName() + "'").getInt("level" + type);
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setLevel(int level, String type) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET level" + type + "=" + level + "\n" +
                "WHERE name='" + player.getName() + "');");
    }


}
