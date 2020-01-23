package com.civiledcode.mcmmo.form;

import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;

public class McMMOHelpWindow extends FormWindowSimple {

    public McMMOHelpWindow() {
        super("McMMO", TextFormat.colorize(Main.lang.getString("mcmmoInformation")).replace("%n", "\n"));
    }

}
