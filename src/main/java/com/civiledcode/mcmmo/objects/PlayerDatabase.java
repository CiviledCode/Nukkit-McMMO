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

    public String TYPE_MINE = "Mine";
    public String TYPE_COMBAT = "Combat";
    public String TYPE_FARMING = "Farming";

    public int getExperience(String type) {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experience" + type + " FROM players WHERE name='" + player.getName() + "'").getInt("experience" + type);
        } catch (SQLException e) {
            return 0;
        }
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
        return (int) (Main.getInstance().getConfig().getInt("xpEarnedBy" + type) * Math.pow(Main.baseChangeAmount, getLevel(type)));
    }

    public int getLevel(String type) {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT level" + type + " FROM players WHERE name='" + player.getName() + "'").getInt("level" + type);
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setLevel(int level, String type) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET level" + type + "=" + level + "\n" +
                "WHERE name='" + player.getName() + "';");
    }

}
