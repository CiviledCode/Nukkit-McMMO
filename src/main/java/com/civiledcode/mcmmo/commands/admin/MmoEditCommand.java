package com.civiledcode.mcmmo.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class MmoEditCommand extends Command {

    public MmoEditCommand() {
        super("mmoedit", TextFormat.colorize(Main.lang.getString("mmoEditCommandDescription")), "/mmmo [player] [skill] [level]");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            if (!sender.isOp()) sender.sendMessage(TextFormat.colorize(Main.lang.getString("mustBeOp")));
            if (args.length < 5) {
                sender.sendMessage("Usage: /mmoedit [player] [skill] [level]");
                return true;
            }
            Player player = sender.getServer().getPlayer(args[0]);
            if (player != null) {
                if (player.isOnline()) {
                    PlayerDatabase db = new PlayerDatabase(player);
                    String type = args[1].substring(0, 1).toUpperCase() + args[1].substring(1);
                    db.setLevel(Integer.parseInt(args[2]), type);
                    sender.sendMessage(TextFormat.colorize(Main.lang.getString("editedUser")));
                } else {
                    sender.sendMessage(TextFormat.colorize(Main.lang.getString("invalidPlayer")));
                }
            } else {
                sender.sendMessage(TextFormat.colorize(Main.lang.getString("invalidPlayer")));
            }
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}