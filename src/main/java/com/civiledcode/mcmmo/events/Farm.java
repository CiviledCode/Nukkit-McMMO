package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.block.*;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Farm implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Block block = event.getBlock();
        Item item = event.getItem();
        if (block instanceof BlockGrass && item.getName().contains("Hoe")) {
            Player player = event.getPlayer();
            PlayerDatabase database = new PlayerDatabase(player);
            int updatedExperience = database.getExperience(database.TYPE_FARMING) + Main.cfg.getInt("xpEarnedByFarming");
            database.setExperience(updatedExperience, database.TYPE_FARMING);
        }
        if (block instanceof BlockFarmland && item.getName().contains("Seed")) {
            Player player = event.getPlayer();
            PlayerDatabase database = new PlayerDatabase(player);
            int updatedExperience = database.getExperience(database.TYPE_FARMING) + Main.cfg.getInt("xpEarnedByFarming");
            database.setExperience(updatedExperience, database.TYPE_FARMING);
        }
    }

    @EventHandler
    public void onBreakCrop(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block instanceof BlockCrops) {
            Player player = event.getPlayer();
            PlayerDatabase database = new PlayerDatabase(player);
            int updatedExperience = database.getExperience(database.TYPE_FARMING) + Main.cfg.getInt("xpEarnedByFarming");
            database.setExperience(updatedExperience, database.TYPE_FARMING);
        }
    }

}
