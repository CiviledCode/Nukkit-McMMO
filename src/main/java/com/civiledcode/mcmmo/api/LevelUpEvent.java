package com.civiledcode.mcmmo.api;


import cn.nukkit.Player;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;

public class LevelUpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private String type;
    private int level;
    private Player player;

    public LevelUpEvent(String type, int level, Player player) {
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
