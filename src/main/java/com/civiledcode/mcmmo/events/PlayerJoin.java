package com.civiledcode.mcmmo.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.civiledcode.mcmmo.Main;

import java.sql.SQLException;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
                if(Main.getPlayerDatabase().getInt("SELECT * FROM players WHERE name='" + event.getPlayer().getName() + "'", "levelMine") == -1) {
                Main.getPlayerDatabase().executeUpdate("INSERT INTO players (name,experienceMine,experienceCombat,experienceFarming,levelMine,levelCombat,levelFarming) VALUES (\n" +
                        "  '" + event.getPlayer().getName() + "',\n" +
                        "  0,\n" +
                        "  0,\n" +
                        "  0,\n" +
                        "  1,\n" +
                        "  1,\n" +
                        "  1\n" +
                        ");");
            }
    }
}
