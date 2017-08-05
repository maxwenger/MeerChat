package net.seasharp.minechat;

import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{


    public void onEnable() {
        registerConfig();
        registerEvents();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }

    private void registerConfig() {
        FileConfiguration config = this.getConfig();

        saveDefaultConfigs(config);
        registerDiscord(config);
    }

    private void registerDiscord(FileConfiguration config) {
        String discordToken = config.getString("discord-token");
        Discord.setToken(discordToken);
        getLogger().info("Discord connected.");
    }

    private void saveDefaultConfigs(FileConfiguration config) {
        config.options().copyDefaults(true);
        saveConfig();
    }

    public void onDisable() {
        saveConfig();
    }

}
