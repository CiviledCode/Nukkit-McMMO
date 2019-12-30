package com.civiledcode.mcmmo;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.commands.SkillCommand;
import com.civiledcode.mcmmo.events.*;
import com.civiledcode.mcmmo.objects.Database;
import com.civiledcode.mcmmo.form.Screen;

import java.io.File;

public class Main extends PluginBase implements Listener {

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
        lang = new Config(getDataFolder() + File.separator + "lang.yml", Config.YAML);
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
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new CheckRewardsEvent(), this);

        // Skill Events
        getServer().getPluginManager().registerEvents(new Acrobatics(), this);
        getServer().getPluginManager().registerEvents(new Archery(), this);
        getServer().getPluginManager().registerEvents(new Excavation(), this);
        getServer().getPluginManager().registerEvents(new Farming(), this);
        getServer().getPluginManager().registerEvents(new Mining(), this);
        getServer().getPluginManager().registerEvents(new Swords(), this);
        getServer().getPluginManager().registerEvents(new Unarmed(), this);
        getServer().getPluginManager().registerEvents(new Woodcutting(), this);
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


    @EventHandler
    public void onFormResponse(PlayerFormRespondedEvent event) {
        if (event.getResponse() == null) return;
        if (!(event.getWindow() instanceof Screen)) return;
        ((Screen)event.getWindow()).onResponse(event);
    }

}
