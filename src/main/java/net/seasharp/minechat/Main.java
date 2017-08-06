package net.seasharp.minechat;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private Configuration config;

    public void onEnable() {
        loadConfig();
        getLogger().info("Using Discord token: '" + config.DiscordClientToken + "'");
        getLogger().info("Using Discord channel: '#" + config.DiscordChannelName + "' at index '" + config.DiscordChannelIndex + "'");
        registerEvents();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(config.DiscordClientToken, config.DiscordChannelName, config.DiscordChannelIndex), this);
    }

    private void loadConfig() {
        config = new Configuration(this);
        config.saveDefaultConfig();
        config.loadConfig();
    }

    public void onDisable() {
        config.saveConfig();
    }

}
