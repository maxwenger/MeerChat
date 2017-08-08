package net.seasharp.meerchat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {

    private FileConfiguration config;
    private JavaPlugin plugin;

    public Configuration(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public void saveDefaultConfig() {
        config.options().copyDefaults(true);
        saveConfig();
    }

    public void saveConfig() {
        plugin.saveConfig();
    }

    public String getDiscordClientToken() {
        return config.getString("discord-token");
    }

    public String getDiscordChannelName(){
        return config.getString("discord-channel-name");
    }

    public int getDiscordChannelIndex(){
        return config.getInt("discord-channel-index");
    }

    public boolean getUseChatListener(){
        return config.getBoolean("use-chat-listener");
    }

    public boolean getUsePlayerActivityListener(){
        return config.getBoolean("use-player-activity-listener");
    }
}
