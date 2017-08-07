package net.seasharp.meerchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main extends JavaPlugin{

    private Configuration config;
    private DiscordBot bot;

    @Override
    public void onEnable() {
        loadConfig();

        getLogger().info("Using Discord token: '" + config.DiscordClientToken + "'");
        getLogger().info("Using Discord channel: '#" + config.DiscordChannelName + "' at index '" + config.DiscordChannelIndex + "'");

        bot = new DiscordBot(config.DiscordClientToken, config.DiscordChannelName, config.DiscordChannelIndex);

        registerEvents();

        bot.sendMessage("*[MeerChat v0.1 initialized - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]*");

        getCommand("meerchat").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                return true;
            }
        });
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

    @Override
    public void onDisable() {
        config.saveConfig();

        bot.sendMessage("*[MeerChat v0.1 has stopped - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]*");
    }

}
