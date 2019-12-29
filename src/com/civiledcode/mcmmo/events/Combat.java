package com.civiledcode.mcmmo.events;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityDeathEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class Combat implements Listener {

    @EventHandler
    public void onEntityKill(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            if (entity.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || entity.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                Player player = (Player) ((EntityDamageByEntityEvent) entity.getLastDamageCause()).getDamager();
                PlayerDatabase database = new PlayerDatabase(player);
                int updatedExperience = database.getExperience() + Main.cfg.getInt("xpEarnedByKillingEntity");
                database.setExperience(updatedExperience);
            }
        }
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            Player damager = (Player) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
            PlayerDatabase database = new PlayerDatabase(damager);
            int updatedExperience = database.getExperience() + Main.cfg.getInt("xpEarnedByKillingPlayer");
            database.setExperience(updatedExperience);
        }
    }

}
