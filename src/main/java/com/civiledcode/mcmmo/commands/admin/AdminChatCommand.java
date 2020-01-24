package com.civiledcode.mcmmo.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;

import java.util.StringJoiner;

public class AdminChatCommand extends Command {

    public AdminChatCommand() {
        super("adminchat", TextFormat.colorize(Main.lang.getString("mcmmoAdminChatCommandDescription")), "/adminchat [message]", new String[]{"ac"});
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            if (!sender.isOp()) sender.sendMessage(TextFormat.colorize(Main.lang.getString("mustBeOp")));
            if (args.length < 2) {
                sender.sendMessage("Usage: /adminchat [message]");
                return true;
            }
            StringJoiner msg = new StringJoiner(" ");
            for (String arg : args) msg.add(arg);
            for (Player player : sender.getServer().getOnlinePlayers().values()) {
                if (player.isOp()) {
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("mcmmoAdminChatFormat")).replace("{USER}", sender.getName()).replace("{MESSAGE}", msg.toString()));
                }
            }
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}