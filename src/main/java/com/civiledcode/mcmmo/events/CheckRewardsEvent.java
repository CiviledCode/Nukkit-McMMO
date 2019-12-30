package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.Config;
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
        Config config = Main.cfg;
        ConfigSection cs = config.getSection(type.toLowerCase() + "-" + level);
        String command = cs.getString("command");
        String tip = cs.getString("tip");
        if (command.length() > 2 && tip.length() > 2) {
            Main.getInstance().getServer().dispatchCommand(Main.getInstance().getServer().getConsoleSender(), command.replace("{PLAYER}", player.getName()).replace("{PERM}", "999999"));
            player.sendActionBar(TextFormat.colorize(tip));
        }
    }

}
