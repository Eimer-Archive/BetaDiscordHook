package com.imjustdoom.listener;

import com.imjustdoom.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        final Player player = event.getPlayer();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setThumbnail("https://crafatar.com/avatars/" + Main.INSTANCE.api.getUserUUID(event.getPlayer().getName()));
        embedBuilder.setTitle(player.getName() + " has joined the server");
        embedBuilder.setColor(Color.GREEN);

        Main.INSTANCE.jda.getTextChannelById(Main.INSTANCE.channel).sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
