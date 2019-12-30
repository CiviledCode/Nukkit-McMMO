package com.civiledcode.mcmmo.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.item.Item;

public class Excavation implements Listener {

    @EventHandler
    public void onDestroyWithShovel(BlockBreakEvent event) {
        Item item = event.getItem();
        if (item.isShovel()) {
            // TODO: Add XP for Excavation
        }
    }

}
