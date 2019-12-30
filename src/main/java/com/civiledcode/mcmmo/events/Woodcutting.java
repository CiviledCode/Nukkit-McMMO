package com.civiledcode.mcmmo.events;

import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;

public class Woodcutting implements Listener {

    @EventHandler
    public void onWoodCut(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getId() == 17 || block.getId() == 162) {
            // TODO: Add XP for Archery
        }
    }

}
