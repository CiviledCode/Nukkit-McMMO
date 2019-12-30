package com.civiledcode.mcmmo.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.form.SkillFormWindow;


public class SkillCommand extends Command {

    public SkillCommand() {
        super("skill", TextFormat.colorize(Main.lang.getString("skillDescription")), "/skill");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.showFormWindow(new SkillFormWindow("Skill", TextFormat.colorize(Main.lang.getString("skillDescription"))));
        } else {
            sender.sendMessage(TextFormat.colorize(Main.lang.getString("consoleSender")));
        }
        return true;
    }

}