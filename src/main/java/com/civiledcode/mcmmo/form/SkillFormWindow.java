package com.civiledcode.mcmmo.form;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;
import com.civiledcode.mcmmo.objects.PlayerDatabase;

public class SkillFormWindow extends FormWindowSimple implements Screen {

    public SkillFormWindow(String title, String context) {
        super(title, context);
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("mining")), new ElementButtonImageData("URL", "")));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("combat")), new ElementButtonImageData("URL", "")));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("farming")), new ElementButtonImageData("URL", "")));
    }

    @Override
    public void onResponse(PlayerFormRespondedEvent event) {
        Player player = event.getPlayer();
        PlayerDatabase database = new PlayerDatabase(player);
        int response = getResponse().getClickedButtonId();
        switch (response) {
            case 0: {
                int experienceNeeded = database.getExperienceNeededForNextLevel(database.TYPE_MINE) - database.getExperience(database.TYPE_MINE);
                String title = Main.lang.getString("statistics").replace("{TYPE}", "Mining");
                String content = TextFormat.colorize(Main.lang.getString("level")) + database.getLevel(database.TYPE_MINE) + "\n" + TextFormat.colorize(Main.lang.getString("experience")) + database.getExperience(database.TYPE_MINE) + "\n" + TextFormat.colorize(Main.lang.getString("experienceNeeded")) + experienceNeeded;
                FormWindowSimple form = new FormWindowSimple(title, content);
                player.showFormWindow(form);
                break;
            }
            case 1: {
                int experienceNeeded = database.getExperienceNeededForNextLevel(database.TYPE_COMBAT) - database.getExperience(database.TYPE_COMBAT);
                String title = Main.lang.getString("statistics").replace("{TYPE}", "Combat");
                String content = TextFormat.colorize(Main.lang.getString("level")) + database.getLevel(database.TYPE_COMBAT) + "\n" + TextFormat.colorize(Main.lang.getString("experience")) + database.getExperience(database.TYPE_COMBAT) + "\n" + TextFormat.colorize(Main.lang.getString("experienceNeeded")) + experienceNeeded;
                FormWindowSimple form = new FormWindowSimple(title, content);
                player.showFormWindow(form);
                break;
            }
            case 2: {
                int experienceNeeded = database.getExperienceNeededForNextLevel(database.TYPE_FARMING) - database.getExperience(database.TYPE_FARMING);
                String title = Main.lang.getString("statistics").replace("{TYPE}", "Farming");
                String content = TextFormat.colorize(Main.lang.getString("level")) + database.getLevel(database.TYPE_FARMING) + "\n" + TextFormat.colorize(Main.lang.getString("experience")) + database.getExperience(database.TYPE_FARMING) + "\n" + TextFormat.colorize(Main.lang.getString("experienceNeeded")) + experienceNeeded;
                FormWindowSimple form = new FormWindowSimple(title, content);
                player.showFormWindow(form);
            }
        }
    }

}
