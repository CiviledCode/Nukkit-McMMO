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

    public static Config lang;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        lang = new Config("lang.yml");
        getLogger().info(TextFormat.colorize(lang.getString("bootMessage")));
        instance = this;
        database = new Database("playerData");
        cfg = getConfig();
        registerCommands();
        registerEvents();
        registerTasks();
    }

    public void onDisable() {
        getLogger().info(TextFormat.colorize(lang.getString("shutdownMessage")));
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
