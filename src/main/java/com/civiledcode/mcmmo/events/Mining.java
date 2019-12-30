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
            database.addExperience(Main.cfg.getInt("xpEarnedByMining"), "Mining");
        } else if (block instanceof BlockOreCoal) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMining") * 2, "Mining");
        } else if (block instanceof BlockOreIron) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMining") * 3, "Mining");
        } else if (block instanceof BlockOreGold) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMining") * 4, "Mining");
        } else if (block instanceof BlockOreDiamond) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMining") * 5, "Mining");
        } else if (block instanceof BlockOreEmerald) {
            database.addExperience(Main.cfg.getInt("xpEarnedByMining") * 6, "Mining");
        }
    }

}
