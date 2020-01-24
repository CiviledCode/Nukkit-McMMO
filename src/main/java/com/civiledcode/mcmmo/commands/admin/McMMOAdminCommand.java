package com.civiledcode.mcmmo.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.form.McMMOAdminHelpWindow;

public class McMMOAdminCommand extends Command {

    public McMMOAdminCommand() {
        super("mcadmin", TextFormat.colorize(Main.lang.getString("mcmmoAdminCommandDescription")), "/mcadmin");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            if (!sender.isOp()) sender.sendMessage(TextFormat.colorize(Main.lang.getString("mustBeOp")));
            Player player = (Player) sender;
            player.showFormWindow(new McMMOAdminHelpWindow());
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}