package com.civiledcode.mcmmo;

import cn.nukkit.Player;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class CheckLevelTask extends NukkitRunnable {

    @Override
    public void run() {
        for (Player player : Main.getInstance().getServer().getOnlinePlayers().values()) {
            PlayerDatabase database = new PlayerDatabase(player);
            int xpForMining = database.getExperienceForMining();
            int xpForEntities = database.getExperienceForEntities();
            int xpForPlayers = database.getExperienceForPlayers();
            int xpForFarming = database.getExperienceForFarming();
            int miningLevel = xpForMining / Main.cfg.getInt("baseMiningLevelXp");
            int entityLevel = xpForEntities / Main.cfg.getInt("baseKillingEntityLevelXp");
            int playerLevel = xpForPlayers / Main.cfg.getInt("baseKillingPlayerLevelXp");
            int farmingLevel = xpForFarming / Main.cfg.getInt("baseFarmingLevelXp");
            if (miningLevel != database.getLevelForMining()) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + miningLevel + " on mining!"));
                database.setLevelForMining(miningLevel);
            }
            if (entityLevel != database.getLevelForEntities()) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + entityLevel + " on mobs!"));
                database.setLevelForEntities(entityLevel);
            }
            if (playerLevel != database.getLevelForPlayers()) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + playerLevel + " on players!"));
                database.setLevelForPlayers(playerLevel);
            }
            if (farmingLevel != database.getLevelForFarming()) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + farmingLevel + " on farming!"));
                database.setLevelForFarming(farmingLevel);
            }
        }
    }

}
