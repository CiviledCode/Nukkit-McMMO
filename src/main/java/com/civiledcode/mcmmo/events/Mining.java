package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.block.*;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Mining implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        PlayerDatabase database = new PlayerDatabase(player);
        if (block instanceof BlockStone) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMine"), "Mine");
        } else if (block instanceof BlockOreCoal) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMine") * 2, "Mine");
        } else if (block instanceof BlockOreIron) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMine") * 3, "Mine");
        } else if (block instanceof BlockOreGold) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMine") * 4, "Mine");
        } else if (block instanceof BlockOreDiamond) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMine") * 5, "Mine");
        } else if (block instanceof BlockOreEmerald) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMine") * 6, "Mine");
        }
    }

}
