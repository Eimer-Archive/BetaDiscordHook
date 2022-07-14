package com.imjustdoom;

import com.imjustdoom.listener.*;
import dev.nova.nmoyang.api.Mojang;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {

    public static Main INSTANCE;
    public Mojang api;
    public JDA jda;
    public String channel;
    public String token;
    public String description;

    public Main() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        reload();

        try {
            jda = JDABuilder.createDefault(token)
                    .setActivity(Activity.playing(description)).build();

            jda.addEventListener(new DiscordMessageListener());
        } catch (LoginException e) {
            e.printStackTrace();
        }

        api = new Mojang();

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    public void reload() {
        try {
            this.getConfiguration().load();
        } catch (Exception ignored) {}
        this.token = this.getConfiguration().getString("token", "");
        this.description = this.getConfiguration().getString("description", "Connected to chat...");
        this.channel = this.getConfiguration().getString("channel", "0");
        this.getConfiguration().save();

        System.out.println(token);
        System.out.println(description);
        System.out.println(channel);
    }

    @Override
    public void onDisable() {

    }
}
