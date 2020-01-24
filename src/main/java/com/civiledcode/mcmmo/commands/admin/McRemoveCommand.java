package com.civiledcode.mcmmo.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;

import java.sql.SQLException;
import java.sql.Statement;

public class McRemoveCommand extends Command {

    public McRemoveCommand() {
        super("mcremove", TextFormat.colorize(Main.lang.getString("mcmmoRemoveCommandDescription")), "/mcremove");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            try {
                if (!sender.isOp()) sender.sendMessage(TextFormat.colorize(Main.lang.getString("mustBeOp")));
                String playerName = args[1];
                Statement stmt = Main.getPlayerDatabase().createStatement();
                stmt.executeUpdate("DELETE FROM players WHERE name='" + playerName + "'");
                sender.sendMessage(TextFormat.colorize(Main.lang.getString("resetUser")).replace("{PLAYER}", playerName));
                stmt.close();
            } catch (SQLException e) {
                sender.sendMessage(TextFormat.colorize(Main.lang.getString("unableToReachDatabase")));
            }
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}