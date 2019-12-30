package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockDirt;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Excavation implements Listener {

    @EventHandler
    public void onDestroyWithShovel(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block instanceof BlockDirt) {
            Player player = event.getPlayer();
            PlayerDatabase database = new PlayerDatabase(player);
            database.addExperience(Main.cfg.getInt("xpEarnedByExcavation"), "Excavation");
        }
    }

}
