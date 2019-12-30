package com.civiledcode.mcmmo.objects;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.api.LevelUpEvent;

import java.sql.SQLException;

public class PlayerDatabase {

    private Player player;

    public PlayerDatabase(Player player) {
        this.player = player;
    }

    public String TYPE_ACROBATICS = "Acrobatics";
    public String TYPE_ARCHERY = "Archery";
    public String TYPE_EXCAVATION = "Excavation";
    public String TYPE_FARMING = "Farming";
    public String TYPE_MINING = "Mining";
    public String TYPE_SWORDS = "Swords";
    public String TYPE_UNARMED = "Unarmed";
    public String TYPE_WOODCUTTING = "Woodcutting";

    public int getExperience(String type) {
        return Main.getPlayerDatabase().getInt("SELECT experience" + type + " FROM players WHERE name='" + player.getName() + "'", "experience" + type);
    }

    public void setExperience(int Experience, String type) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experience" + type + "=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "';");
    }

    public void addExperience(int Experience, String type) {
        int finalAmount = getExperience(type) + Experience;
        int neededForLevel = getExperienceNeededForNextLevel(type);
        if(finalAmount >= neededForLevel) {
            LevelUpEvent event = new LevelUpEvent(type, getLevel(type), player);
            Main.getInstance().getServer().getPluginManager().callEvent(event);
            setLevel(getLevel(type) + 1, type);
            setExperience(0, type);
            player.sendTitle(TextFormat.colorize(Main.lang.getString("levelUp")), TextFormat.colorize(Main.lang.getString("levelUpSubtitle").replace("{LEVEL}", "" + getLevel(type)).replace("{TYPE}", type)));
        } else {
            setExperience(finalAmount, type);
        }
    }

    public int getExperienceNeededForNextLevel(String type) {
        return (int) (Main.getInstance().getConfig().getInt("base" + type + "LevelXp") * Math.pow(Main.baseChangeAmount, getLevel(type)));
    }

    public int getLevel(String type) {
        return Main.getPlayerDatabase().getInt("SELECT level" + type + " FROM players WHERE name='" + player.getName() + "'", "level" + type);
    }

    public void setLevel(int level, String type) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET level" + type + "=" + level + "\n" +
                "WHERE name='" + player.getName() + "';");
    }

}
