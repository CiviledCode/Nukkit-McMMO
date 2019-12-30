package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Acrobatics implements Listener {

    @EventHandler
    public void onJump(PlayerMoveEvent event) {
        if (!event.getPlayer().isOnGround()) {
            Player player = event.getPlayer();
            PlayerDatabase database = new PlayerDatabase(player);
            database.addExperience(Main.cfg.getInt("xpEarnedByAcrobatics"), "Acrobatics");
        }
    }

}
