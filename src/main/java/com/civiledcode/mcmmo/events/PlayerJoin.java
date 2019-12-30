package com.civiledcode.mcmmo.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.civiledcode.mcmmo.Main;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Main.getPlayerDatabase().executeUpdate("INSERT INTO players (name,experienceMine,experienceCombat,experienceFarming,levelMine,levelCombat,levelFarming) VALUES (\n" +
                "  'CiviledYT',\n" +
                "  '0',\n" +
                "  '0',\n" +
                "  '0',\n" +
                "  '0',\n" +
                "  '0',\n" +
                "  '0'\n" +
                ");");
    }

}
