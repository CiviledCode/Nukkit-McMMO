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
        ConfigSection cs = config.getSection(type.toLowerCase().replace("mine", "mining"));
        String levelCommand = getLevelCommand(cs.toString(), level);
        String tipCommand = getTipCommand(cs.toString() + "!!!", level);
        if (levelCommand != null && tipCommand != null) {
            if (levelCommand.length() > 2) Main.getInstance().getServer().dispatchCommand(Main.getInstance().getServer().getConsoleSender(), levelCommand.replace("{PLAYER}", player.getName()).replace("{PERM}", "999999"));
            if (tipCommand.length() > 2) player.sendActionBar(TextFormat.colorize(tipCommand));
        }
    }

    public static String getLevelCommand(String cs, int level) {
        if(!cs.contains("{" + level + "={command=")) return null;
        String splitTag = cs.split("\\{" + level + "=\\{command=")[1];
        return splitTag.split(", tip=")[0];
    }

    public static String getTipCommand(String cs, int level) {
        if(!cs.contains("{" + level + "={command=")) return null;
        String splitTag = cs.split("\\{" + level + "=\\{command=")[1];
        String levelInfo = splitTag.split("!!!")[0];
        String levelTip = levelInfo.split("tip=")[1];
        return levelTip.split("}}")[0];
    }

}
