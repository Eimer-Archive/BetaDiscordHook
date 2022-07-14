package com.imjustdoom.listener;

import com.imjustdoom.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.awt.*;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if(!(event.getEntity() instanceof Player)) return;

        final Player player = (Player) event.getEntity();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(player.getName() + " has died");
        embedBuilder.setColor(Color.ORANGE);

        Main.INSTANCE.jda.getTextChannelById(Main.INSTANCE.channel).sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
