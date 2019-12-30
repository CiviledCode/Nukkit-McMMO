package com.civiledcode.mcmmo.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;

public class Acrobatics implements Listener {

    @EventHandler
    public void onJump(PlayerMoveEvent event) {
        if (!event.getPlayer().isOnGround()) {
            // TODO: Add XP for Acrobatics
        }
    }

}
