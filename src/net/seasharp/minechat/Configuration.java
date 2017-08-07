package net.seasharp.minechat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Configuration {
    public String DiscordClientToken;
    public String DiscordChannelId;

    private FileConfiguration config;
    private JavaPlugin plugin;

    public Configuration(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public void createConfig() {
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdirs();
            }
            File file = new File(plugin.getDataFolder(), "config.yml");
            if (!file.exists()) {
                plugin.getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                plugin.getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private void saveDefaultConfig() {
        config.options().copyDefaults(true);
        saveConfig();
    }

    public void saveConfig() {
        plugin.saveConfig();
    }

    public void loadConfig() {
        DiscordClientToken = config.getString("discord-token");
        DiscordChannelId = config.getString("discord-channel-id");
    }
}
