package com.civiledcode.mcmmo.events;


import cn.nukkit.Player;
import cn.nukkit.event.Event;

public class LevelupEvent extends Event {
    private String type;
    private int level;
    private Player player;

    public LevelupEvent(String type, int level, Player player) {
        this.type = type;
        this.level = level;
        this.player = player;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }
}
