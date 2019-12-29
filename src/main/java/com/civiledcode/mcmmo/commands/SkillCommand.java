package com.civiledcode.mcmmo.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;


public class SkillCommand extends Command {

    public SkillCommand() {
        super("skill", TextFormat.colorize(Main.lang.getString("skillDescription")), "/skill <mining / combat / farming>");
    }

    @Override
    public boolean execute(CommandSender sender, String string, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerDatabase database = new PlayerDatabase(player);
            switch (args[0]) {
                case "mining": {
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("statistics").replace("{TYPE}", "Mining")));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("level")) + database.getLevel(database.TYPE_MINE));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("experience")) + database.getExperience(database.TYPE_MINE));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("experienceNeeded")) + database.getExperienceNeededForNextLevel(database.TYPE_MINE));
                    break;
                }
                case "combat": {
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("combatStatistics").replace("{TYPE}", "Combat")));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("level")) + database.getLevel(database.TYPE_COMBAT));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("experience")) + database.getExperience(database.TYPE_COMBAT));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("experienceNeeded")) + database.getExperienceNeededForNextLevel(database.TYPE_COMBAT));
                    break;
                }
                case "farming": {
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("farmingStatistics").replace("{TYPE}", "Farming")));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("level")) + database.getLevel(database.TYPE_FARMING));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("experience")) + database.getExperience(database.TYPE_FARMING));
                    player.sendMessage(TextFormat.colorize(Main.lang.getString("experienceNeeded")) + database.getExperienceNeededForNextLevel(database.TYPE_FARMING));
                    break;
                }
                default: {
                    return false;
                }
            }
        }
        return true;
    }

}