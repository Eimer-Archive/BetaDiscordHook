package com.imjustdoom.listener;

import com.imjustdoom.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DiscordMessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(!event.getMessage().getTextChannel().getId().equals(Main.INSTANCE.channel) || event.getAuthor().isBot()) return;

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("<[Discord] " + event.getAuthor().getName() + "> " + event.getMessage().getContentRaw());
        }
    }
}