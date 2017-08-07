package net.seasharp.minechat;

import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main extends JavaPlugin{

    private Configuration config;
    private DiscordBot bot;

    public void onEnable() {
        loadConfig();

        getLogger().info("Using Discord token: '" + config.DiscordClientToken + "'");
        getLogger().info("Using Discord channel: '#" + config.DiscordChannelName + "' at index '" + config.DiscordChannelIndex + "'");

        bot = new DiscordBot(config.DiscordClientToken, config.DiscordChannelName, config.DiscordChannelIndex);

        registerEvents();

        bot.sendMessage("*[MineChat v0.1 initialized - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]*");

    }

    private void registerEvents() {
        if (config.UseChatListener) {
            getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(bot), this);
        }

        if (config.UsePlayerJoinListener) {
            getServer().getPluginManager().registerEvents(new OnPlayerJoinListener(bot), this);
        }

        if (config.UsePlayerLeaveListener) {
            getServer().getPluginManager().registerEvents(new OnPlayerLeaveListener(bot), this);
        }
    }

    private void loadConfig() {
        config = new Configuration(this);
        config.saveDefaultConfig();
        config.loadConfig();
    }

    public void onDisable() {
        config.saveConfig();

        bot.sendMessage("*[MineChat v0.1 has stopped - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]*");
    }

}
