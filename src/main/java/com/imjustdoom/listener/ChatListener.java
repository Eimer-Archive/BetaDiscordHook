package com.imjustdoom.listener;

import com.imjustdoom.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {

        Main.INSTANCE.jda.getTextChannelById(Main.INSTANCE.channel).sendMessage(event.getPlayer().getName() + ": " + event.getMessage()).queue();
    }
}
