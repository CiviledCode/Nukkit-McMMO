package com.civiledcode.mcmmo.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.form.McMMOHelpWindow;


public class McMMOCommand extends Command {

    public McMMOCommand() {
        super("mcmmo", TextFormat.colorize(Main.lang.getString("mcmmoCommandDescription")), "/mcmmo");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.showFormWindow(new McMMOHelpWindow());
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}