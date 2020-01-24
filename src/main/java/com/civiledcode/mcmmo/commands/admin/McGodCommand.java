package com.civiledcode.mcmmo.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;

public class McGodCommand extends Command {

    public McGodCommand() {
        super("mcgod", TextFormat.colorize(Main.lang.getString("mcmmoGodCommandDescription")), "/mcgod");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            if (!sender.isOp()) sender.sendMessage(TextFormat.colorize(Main.lang.getString("mustBeOp")));
            Player player = (Player) sender;
            if (Main.god.contains(player)) {
                Main.god.remove(player);
                sender.sendMessage(TextFormat.colorize(Main.lang.getString("godEnabled")));
            } else {
                Main.god.add(player);
                sender.sendMessage(TextFormat.colorize(Main.lang.getString("godDisabled")));
            }
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}