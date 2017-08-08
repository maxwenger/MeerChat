package net.seasharp.meerchat;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private Configuration config;

    @Override
    public void onEnable() {
        loadConfig();
        registerEvents();
        subscribeChatBots();

        getCommand("meerchat-reload").setExecutor(new PlayerCommandListener());
    }

    private void subscribeChatBots() {
        DiscordBot discordBot = new DiscordBot(
                config.getDiscordClientToken(),
                config.getDiscordChannelName(),
                config.getDiscordChannelIndex());

        SubscribedChatBots.subscribeChatBot(discordBot);
    }

    private void registerEvents() {
        if (config.getUseChatListener()) {
            registerEvent(new AsyncPlayerChatListener());
        }

        if (config.getUsePlayerActivityListener()) {
            registerEvent(new OnPlayerJoinListener());
            registerEvent(new OnPlayerLeaveListener());
        }
    }

    private void registerEvent(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    private void loadConfig() {
        config = new Configuration(this);
        config.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }

}
