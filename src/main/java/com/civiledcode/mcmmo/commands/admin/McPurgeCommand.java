package com.civiledcode.mcmmo.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class McPurgeCommand extends Command {

    public McPurgeCommand() {
        super("mcpurge", TextFormat.colorize(Main.lang.getString("mcmmoPurgeCommandDescription")), "/mcpurge");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            try {
                if (!sender.isOp()) sender.sendMessage(TextFormat.colorize(Main.lang.getString("mustBeOp")));
                Statement stmtGrab = Main.getPlayerDatabase().createStatement();
                ResultSet executeSelect = stmtGrab.executeQuery("SELECT * FROM players");
                while (executeSelect.next()) {
                    int experienceAcrobatics = executeSelect.getInt("experienceAcrobatics");
                    int experienceArchery = executeSelect.getInt("experienceArchery");
                    int experienceExcavation = executeSelect.getInt("experienceExcavation");
                    int experienceFarming = executeSelect.getInt("experienceFarming");
                    int experienceMining = executeSelect.getInt("experienceMining");
                    int experienceSwords = executeSelect.getInt("experienceSwords");
                    int experienceUnarmed = executeSelect.getInt("experienceUnarmed");
                    int experienceWoodcutting = executeSelect.getInt("experienceWoodcutting");
                    int levelAcrobatics = executeSelect.getInt("levelAcrobatics");
                    int levelArchery = executeSelect.getInt("levelArchery");
                    int levelExcavation = executeSelect.getInt("levelExcavation");
                    int levelFarming = executeSelect.getInt("levelFarming");
                    int levelMining = executeSelect.getInt("levelMining");
                    int levelSwords = executeSelect.getInt("levelSwords");
                    int levelUnarmed = executeSelect.getInt("levelUnarmed");
                    int levelWoodcutting = executeSelect.getInt("levelWoodcutting");
                    if (experienceAcrobatics == 0 && experienceArchery == 0 && experienceExcavation == 0 && experienceFarming == 0 && experienceMining == 0 && experienceSwords == 0 && experienceUnarmed == 0 && experienceWoodcutting == 0 && levelAcrobatics == 1 && levelArchery == 1 && levelExcavation == 1 && levelFarming == 1 && levelMining == 1 && levelSwords == 1 && levelUnarmed == 1 && levelWoodcutting == 1) {
                        String name = executeSelect.getString("name");
                        Statement stmtRemove = Main.getPlayerDatabase().createStatement();
                        stmtRemove.executeUpdate("DELETE FROM players WHERE name='" + name + "'");
                        stmtRemove.close();
                    }
                }
                stmtGrab.close();
                sender.sendMessage(Main.lang.getString("purgeSuccess"));
            } catch (SQLException e) {
                sender.sendMessage(TextFormat.colorize(Main.lang.getString("unableToReachDatabase")));
            }
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}