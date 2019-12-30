package com.civiledcode.mcmmo;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.commands.SkillCommand;
import com.civiledcode.mcmmo.events.BlockBreak;
import com.civiledcode.mcmmo.events.Combat;
import com.civiledcode.mcmmo.events.PlayerJoin;
import com.civiledcode.mcmmo.objects.Database;

public class Main extends PluginBase {

    private static Main instance;

    private static Database database;

    public static Config cfg;

    public static Config lang;

    public static double baseChangeAmount;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        database = new Database("database");
        saveDefaultConfig();
        saveResource("lang.yml");
        cfg = getConfig();
        lang = new Config(getDataFolder() + "/lang.yml", Config.YAML);
        getLogger().info(TextFormat.colorize(lang.getString("bootMessage")));
        initializeDatabase();
        registerCommands();
        registerEvents();

        baseChangeAmount = getConfig().getDouble("baseChangeAmount");
    }

    public void onDisable() {
        getLogger().info(TextFormat.colorize(lang.getString("shutdownMessage")));
        saveDefaultConfig();
        saveResource("lang.yml");
    }

    private void registerCommands() {
        getServer().getCommandMap().register("skill", new SkillCommand());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new Combat(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    public static Database getPlayerDatabase() {
        return database;
    }

    private void initializeDatabase() {
        database.executeUpdate("CREATE table IF NOT EXISTS players (\n" +
                "  name text PRIMARY KEY NOT NULL, \n" +
                "  experienceMine integer NOT NULL,\n" +
                "  experienceCombat integer NOT NULL,\n" +
                "  experienceFarming integer NOT NULL,\n" +
                "  levelMine integer NOT NULL,\n" +
                "  levelCombat integer NOT NULL,\n" +
                "  levelFarming integer NOT NULL);");
    }

}
