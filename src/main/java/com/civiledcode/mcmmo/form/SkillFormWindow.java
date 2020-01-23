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
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("acrobatics")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillAcrobaticsImageURL")))));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("archery")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillArcheryImageURL")))));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("excavation")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillExcavationImageURL")))));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("farming")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillFarmingImageURL")))));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("mining")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillMiningImageURL")))));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("swords")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillSwordsImageURL")))));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("unarmed")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillUnarmedImageURL")))));
        addButton(new ElementButton(TextFormat.colorize(Main.lang.getString("woodcutting")), new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, TextFormat.colorize(Main.cfg.getString("skillWoodcuttingImageURL")))));
    }

    @Override
    public void onResponse(PlayerFormRespondedEvent event) {
        Player player = event.getPlayer();
        int response = getResponse().getClickedButtonId();
        switch (response) {
            case 0: {
                showForm(player, PlayerDatabase.TYPE_ACROBATICS);
                break;
            }
            case 1: {
                showForm(player, PlayerDatabase.TYPE_ARCHERY);
                break;
            }
            case 2: {
                showForm(player, PlayerDatabase.TYPE_EXCAVATION);
                break;
            }
            case 3: {
                showForm(player, PlayerDatabase.TYPE_FARMING);
                break;
            }
            case 4: {
                showForm(player, PlayerDatabase.TYPE_MINING);
                break;
            }
            case 5: {
                showForm(player, PlayerDatabase.TYPE_SWORDS);
                break;
            }
            case 6: {
                showForm(player, PlayerDatabase.TYPE_UNARMED);
                break;
            }
            case 7: {
                showForm(player, PlayerDatabase.TYPE_WOODCUTTING);
                break;
            }
        }
    }

    public void showForm(Player player, String type) {
        PlayerDatabase database = new PlayerDatabase(player);
        int experienceNeeded = database.getExperienceNeededForNextLevel(type);
        int percent = (int) ((database.getExperience(type) * 100.0f) / experienceNeeded);
        String title = Main.lang.getString("statistics").replace("{TYPE}", type);
        String content = TextFormat.colorize(Main.lang.getString("level")) + database.getLevel(type) + "\n" + TextFormat.colorize(Main.lang.getString("experience")) + database.getExperience(type) + "/" + experienceNeeded + "\n" + TextFormat.colorize(Main.lang.getString("experiencePercentage")) + percent + "%";
        FormWindowSimple form = new FormWindowSimple(title, content + "%");
        player.showFormWindow(form);
    }

}
