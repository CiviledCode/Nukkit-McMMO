package com.civiledcode.mcmmo.objects;

import cn.nukkit.Player;
import com.civiledcode.mcmmo.Main;

import java.sql.SQLException;

public class PlayerDatabase {

    private Player player;

    public PlayerDatabase(Player player) {
        this.player = player;
    }

    public int getExperience(String source) {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experience"+source+" FROM players WHERE name='" + player.getName() + "'").getInt("experienceMine");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setExperience(String source, int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experienceMine=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }
}
