package com.civiledcode.mcmmo;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.commands.SkillCommand;
import com.civiledcode.mcmmo.events.BlockBreak;
import com.civiledcode.mcmmo.events.Combat;
import com.civiledcode.mcmmo.objects.Database;

public class Main extends PluginBase {

    private static Main instance;

    private static Database database;

    public static Config cfg;

    public static double baseChangeAmount;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        getLogger().info(TextFormat.colorize("&aMc&eMMO has now started."));
        instance = this;
        database = new Database("playerData");
        cfg = getConfig();
        registerCommands();
        registerEvents();
        registerTasks();

        baseChangeAmount = this.getConfig().getDouble("baseChangeAmount");

        database.executeUpdate("CREATE TABLE ");
    }

    public void onDisable() {
        getLogger().info(TextFormat.colorize("&aMc&eMMO is now shutting down."));
    }

    private void registerCommands() {
        getServer().getCommandMap().register("skill", new SkillCommand());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new Combat(), this);
    }

    private void registerTasks() {
        new CheckLevelTask().runTaskTimer(this, 20, 20);
    }

    public static Database getPlayerDatabase() {
        return database;
    }

}
