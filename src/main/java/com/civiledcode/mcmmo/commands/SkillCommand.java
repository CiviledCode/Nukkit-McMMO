package com.civiledcode.mcmmo.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;


public class SkillCommand extends Command {

    public SkillCommand() {
        super("skill", "View your statistics for a skill", "/skill <mining / mobs / pvp / farming>");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
        }
        return true;
    }

}