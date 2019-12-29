package com.civiledcode.mcmmo;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        getLogger().info(TextFormat.colorize("&aMc&eMMO has now started."));
    }

    public void onDisable() {
        getLogger().info(TextFormat.colorize("&aMc&eMMO is now shutting down."));
    }

    public void registerCommands() {

    }

    public void registerEvents() {

    }

    public void registerTasks() {

    }

}
