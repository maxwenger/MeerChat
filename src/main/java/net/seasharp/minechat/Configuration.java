package net.seasharp.minechat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {
    public String DiscordClientToken;
    public String DiscordChannelName;
    public int DiscordChannelIndex;
    public boolean UseChatListener;
    public boolean UsePlayerJoinListener;
    public boolean UsePlayerLeaveListener;

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

    public void loadConfig() {
        DiscordClientToken = config.getString("discord-token");
        DiscordChannelName = config.getString("discord-channel-name");
        DiscordChannelIndex = config.getInt("discord-channel-index");
        UseChatListener = config.getBoolean("use-chat-listener");
        UsePlayerJoinListener = config.getBoolean("use-player-join-listener");
        UsePlayerLeaveListener = config.getBoolean("use-player-leave-listener");
    }
}
