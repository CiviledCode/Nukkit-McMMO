package com.civiledcode.mcmmo;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.events.BlockBreak;
import com.civiledcode.mcmmo.events.Combat;
import com.civiledcode.mcmmo.objects.Database;

public class Main extends PluginBase {

    private static Main instance;

    private static Database database;

    public static Config cfg;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        getLogger().info(TextFormat.colorize("&aMc&eMMO has now started."));
        database = new Database("playerData");
        cfg = getConfig();
        registerCommands();
        registerEvents();
        registerTasks();
    }

    public void onDisable() {
        getLogger().info(TextFormat.colorize("&aMc&eMMO is now shutting down."));
    }

    public void registerCommands() {

    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new Combat(), this);
    }

    public void registerTasks() {

    }

    public static Database getPlayerDatabase() {
        return database;
    }

}
