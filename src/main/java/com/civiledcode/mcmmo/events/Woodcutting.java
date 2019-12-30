package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Woodcutting implements Listener {

    @EventHandler
    public void onWoodCut(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getId() == 17 || block.getId() == 162) {
            Player player = event.getPlayer();
            PlayerDatabase database = new PlayerDatabase(player);
            database.addExperience(Main.cfg.getInt("xpEarnedByWoodcutting"), "Woodcutting");
        }
    }

}
