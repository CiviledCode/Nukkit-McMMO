package com.civiledcode.mcmmo.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.civiledcode.mcmmo.objects.PlayerDatabase;


public class SkillCommand extends Command {

    public SkillCommand() {
        super("skill", "View your statistics for a skill", "/skill <mining / combat / farming>");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerDatabase database = new PlayerDatabase(player);
            switch (args[0]) {
                case "mining": {
                    player.sendMessage("Mining Statistics:");
                    player.sendMessage("Level: " + database.getLevel(database.TYPE_MINE));
                    player.sendMessage("Experience: " + database.getExperience(database.TYPE_MINE));
                    break;
                }
                case "combat": {
                    player.sendMessage("Combat Statistics:");
                    player.sendMessage("Level: " + database.getLevel(database.TYPE_COMBAT));
                    player.sendMessage("Experience: " + database.getExperience(database.TYPE_COMBAT));
                    break;
                }
                case "farming": {
                    player.sendMessage("Farming Statistics:");
                    player.sendMessage("Level: " + database.getLevel(database.TYPE_FARMING));
                    player.sendMessage("Experience: " + database.getExperience(database.TYPE_FARMING));
                }
            }
        }
        return true;
    }

}