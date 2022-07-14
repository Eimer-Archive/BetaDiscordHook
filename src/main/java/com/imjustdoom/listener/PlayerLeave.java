package com.imjustdoom.listener;

import com.imjustdoom.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class PlayerLeave implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        final Player player = event.getPlayer();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setThumbnail("https://crafatar.com/avatars/" + Main.INSTANCE.api.getUserUUID(event.getPlayer().getName()));
        embedBuilder.setTitle(player.getName() + " has left the server");
        embedBuilder.setColor(Color.RED);

        Main.INSTANCE.jda.getTextChannelById(Main.INSTANCE.channel).sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
