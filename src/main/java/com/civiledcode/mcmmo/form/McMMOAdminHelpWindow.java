package com.civiledcode.mcmmo.form;

import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.TextFormat;
import com.civiledcode.mcmmo.Main;

public class McMMOAdminHelpWindow extends FormWindowSimple {

    public McMMOAdminHelpWindow() {
        super(TextFormat.colorize(Main.lang.getString("mcmmoAdminInformationTitle")), TextFormat.colorize(Main.lang.getString("mcmmoAdminInformation")).replace("%n", "\n"));
    }

}
