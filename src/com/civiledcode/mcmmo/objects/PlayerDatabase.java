package com.civiledcode.mcmmo.objects;

import cn.nukkit.Player;
import com.civiledcode.mcmmo.Main;

import java.sql.SQLException;

public class PlayerDatabase {

    private Player player;

    public PlayerDatabase(Player player) {
        this.player = player;
    }

    public int getExperience() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experience FROM players WHERE name='" + player.getName() + "'").getInt("experience");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setExperience(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experience=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

}
