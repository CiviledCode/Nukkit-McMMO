package com.civiledcode.mcmmo;

import cn.nukkit.Player;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class CheckLevelTask extends NukkitRunnable {

    @Override
    public void run() {
        for (Player player : Main.getInstance().getServer().getOnlinePlayers().values()) {
            PlayerDatabase database = new PlayerDatabase(player);
            int xpForMining = database.getExperience(database.TYPE_MINE);
            int xpForEntities = database.getExperience(database.TYPE_MOBS);
            int xpForPlayers = database.getExperience(database.TYPE_PLAYERS);
            int xpForFarming = database.getExperience(database.TYPE_FARMING);
            int miningLevel = xpForMining / Main.cfg.getInt("baseMiningLevelXp");
            int entityLevel = xpForEntities / Main.cfg.getInt("baseKillingEntityLevelXp");
            int playerLevel = xpForPlayers / Main.cfg.getInt("baseKillingPlayerLevelXp");
            int farmingLevel = xpForFarming / Main.cfg.getInt("baseFarmingLevelXp");
            if (miningLevel != database.getLevel(database.TYPE_MINE)) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + miningLevel + " on mining!"));
                database.setLevel(miningLevel, database.TYPE_MINE);
            }
            if (entityLevel != database.getLevel(database.TYPE_MOBS)) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + entityLevel + " on mobs!"));
                database.setLevel(entityLevel, database.TYPE_MOBS);
            }
            if (playerLevel != database.getLevel(database.TYPE_PLAYERS)) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + playerLevel + " on players!"));
                database.setLevel(playerLevel, database.TYPE_PLAYERS);
            }
            if (farmingLevel != database.getLevel(database.TYPE_FARMING)) {
                player.sendTitle(TextFormat.colorize("&e&lLEVEL UP!"), TextFormat.colorize("&eLevel " + farmingLevel + " on farming!"));
                database.setLevel(farmingLevel, database.TYPE_FARMING);
            }
        }
    }

}
