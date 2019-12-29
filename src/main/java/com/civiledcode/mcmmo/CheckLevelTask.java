package com.civiledcode.mcmmo;

import cn.nukkit.Player;
import cn.nukkit.scheduler.NukkitRunnable;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class CheckLevelTask extends NukkitRunnable {

    @Override
    public void run() {
        for (Player player : Main.getInstance().getServer().getOnlinePlayers().values()) {
            PlayerDatabase database = new PlayerDatabase(player);
            int xpForMining = database.getExperience("Mining");
            int xpForEntities = database.getExperience("Combat");

        }
    }

}
