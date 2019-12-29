package com.civiledcode.mcmmo.objects;

import cn.nukkit.Player;
import com.civiledcode.mcmmo.Main;

import java.sql.SQLException;

public class PlayerDatabase {

    private Player player;

    public PlayerDatabase(Player player) {
        this.player = player;
    }

    public int getExperienceForMining() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experienceMine FROM players WHERE name='" + player.getName() + "'").getInt("experienceMine");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setExperienceForMining(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experienceMine=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getLevelForMining() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT levelMine FROM players WHERE name='" + player.getName() + "'").getInt("levelMine");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setLevelForMining(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET levelMine=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getExperienceForEntities() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experienceEntities FROM players WHERE name='" + player.getName() + "'").getInt("experienceEntities");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setExperienceForEntities(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experienceEntities=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getLevelForEntities() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT levelEntities FROM players WHERE name='" + player.getName() + "'").getInt("levelEntities");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setLevelForEntities(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET levelEntities=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getExperienceForPlayers() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experiencePlayers FROM players WHERE name='" + player.getName() + "'").getInt("experiencePlayers");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setExperienceForPlayers(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experiencePlayers=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getLevelForPlayers() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT levelPlayers FROM players WHERE name='" + player.getName() + "'").getInt("levelPlayers");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setLevelForPlayers(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET levelPlayers=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getExperienceForFarming() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT experienceFarming FROM players WHERE name='" + player.getName() + "'").getInt("experienceFarming");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setExperienceForFarming(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET experienceFarming=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

    public int getLevelForFarming() {
        try {
            return Main.getPlayerDatabase().executeSelect("SELECT levelFarming FROM players WHERE name='" + player.getName() + "'").getInt("levelFarming");
        } catch (SQLException e) {
            return 0;
        }
    }

    public void setLevelForFarming(int Experience) {
        Main.getPlayerDatabase().executeUpdate("UPDATE players\n" +
                "SET levelFarming=" + Experience + "\n" +
                "WHERE name='" + player.getName() + "');");
    }

}
