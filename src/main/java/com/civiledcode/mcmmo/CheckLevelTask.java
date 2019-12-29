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
            int xpForCombat = database.getExperience(database.TYPE_COMBAT);
            int xpForFarming = database.getExperience(database.TYPE_FARMING);
            int miningLevel = xpForMining / Main.cfg.getInt("baseMiningLevelXp");
            int combatLevel = xpForCombat / Main.cfg.getInt("baseCombatLevelXp");
            int farmingLevel = xpForFarming / Main.cfg.getInt("baseFarmingLevelXp");
            if (miningLevel != database.getLevel(database.TYPE_MINE)) {
                player.sendTitle(TextFormat.colorize(Main.lang.getString("levelUp")), TextFormat.colorize(Main.lang.getString("levelUpSubtitle").replace("{LEVEL}", "" + miningLevel).replace("{TYPE}", "mining")));
                database.setLevel(miningLevel, database.TYPE_MINE);
            }
            if (combatLevel != database.getLevel(database.TYPE_COMBAT)) {
                player.sendTitle(TextFormat.colorize(Main.lang.getString("levelUp")), TextFormat.colorize(Main.lang.getString("levelUpSubtitle").replace("{LEVEL}", "" + combatLevel).replace("{TYPE}", "combat")));
                database.setLevel(combatLevel, database.TYPE_COMBAT);
            }
            if (farmingLevel != database.getLevel(database.TYPE_FARMING)) {
                player.sendTitle(TextFormat.colorize(Main.lang.getString("levelUp")), TextFormat.colorize(Main.lang.getString("levelUpSubtitle").replace("{LEVEL}", "" + farmingLevel).replace("{TYPE}", "farming")));
                database.setLevel(farmingLevel, database.TYPE_FARMING);
            }
        }
    }

}
