package com.civiledcode.mcmmo.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.civiledcode.mcmmo.Main;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if(Main.getPlayerDatabase().executeSelect("SELECT * FROM players WHERE name='" + event.getPlayer().getName() + "'") == null) {
            Main.getPlayerDatabase().executeUpdate("INSERT INTO players (name, experiencemineine, experiencecombat, experiencefarming, levelmine, levelcombat, levelfarming) VALUES ('"+event.getPlayer().getName()+"',0,0,0,0,0,0)");
        }
    }
}
