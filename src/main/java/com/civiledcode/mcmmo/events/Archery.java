package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Archery implements Listener {

    @EventHandler
    public void onHit(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            if (event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
                Entity damager = ((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager();
                if (damager instanceof Player) {
                    PlayerDatabase database = new PlayerDatabase((Player) damager);
                    database.addExperience(Main.cfg.getInt("xpEarnedByArchery"), "Archery");
                }
            }
        }

    }

}
