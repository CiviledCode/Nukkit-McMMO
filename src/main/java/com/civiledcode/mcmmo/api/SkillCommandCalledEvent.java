package com.civiledcode.mcmmo.api;

import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;

public class SkillCommandCalledEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private String[] args;

    private CommandSender sender;

    public SkillCommandCalledEvent(CommandSender sender, String[] args) {
        this.args = args;
        this.sender = sender;
    }

    public String[] getArgs() {
        return args;
    }

    public CommandSender getSender() {
        return sender;
    }

}
