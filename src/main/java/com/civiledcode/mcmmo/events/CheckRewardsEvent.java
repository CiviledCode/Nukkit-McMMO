package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.ConfigSection;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.api.LevelUpEvent;

public class CheckRewardsEvent implements Listener {

    @EventHandler
    public void onLevelUp(LevelUpEvent event) {
        Player player = event.getPlayer();
        int level = event.getLevel() + 1;
        String type = event.getType();
        ConfigSection config = Main.cfg.getSection("triggers." + type.toLowerCase() + "." + level);
        if (config != null) {
            String command = config.getString("command");
            String tip = config.getString("tip");
            if (command != null) Main.getInstance().getServer().dispatchCommand(Main.getInstance().getServer().getConsoleSender(), command.replace("{PLAYER}", player.getName()).replace("{PERM}", "999999"));
            if (tip != null) player.sendTitle(TextFormat.colorize(tip));
        }
    }

}
