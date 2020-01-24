package com.civiledcode.mcmmo.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class AddLevelCommand extends Command {

    public AddLevelCommand() {
        super("addlevels", TextFormat.colorize(Main.lang.getString("addLevelsCommandDescription")), "/addlevels [type] [amount] <user>");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            try {
                if (!sender.isOp()) sender.sendMessage(TextFormat.colorize(Main.lang.getString("mustBeOp")));
                if (args.length < 2) {
                    sender.sendMessage("Usage: /addlevels [type] [amount] <user>");
                    return true;
                }
                switch (args.length) {
                    case 2: {
                        PlayerDatabase db = new PlayerDatabase((Player) sender);
                        String type = args[0].substring(0, 1).toUpperCase() + args[0].substring(1);
                        int level = db.getLevel(type) + Integer.parseInt(args[1]);
                        db.setLevel(level, type);
                    }
                    case 3: {
                        for (Player player : sender.getServer().getOnlinePlayers().values()) {
                            if (player.getName().equals(args[2])) {
                                PlayerDatabase db = new PlayerDatabase(sender.getServer().getPlayer(args[2]));
                                String type = args[0].substring(0, 1).toUpperCase() + args[0].substring(1);
                                int level = db.getLevel(type) + Integer.parseInt(args[1]);
                                db.setLevel(level, type);
                                return true;
                            }
                        }
                        sender.sendMessage(TextFormat.colorize(Main.lang.getString("invalidPlayer")));
                    }
                }
            } catch (NumberFormatException e) {
                sender.sendMessage("Usage: /addlevels [type] [amount] <user>");
            }
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}