package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Unarmed implements Listener {

    @EventHandler
    public void unarmedFight(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            if (damager.getInventory().getItemInHand().isNull()) {
                PlayerDatabase database = new PlayerDatabase(damager);
                database.addExperience(Main.cfg.getInt("xpEarnedByUnarmed"), "Unarmed");
            }
        }
    }

}
