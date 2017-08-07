package net.seasharp.minechat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPluginLoader;

public class AsyncPlayerChatListener implements Listener {

    private String token;
    DiscordBot bot;

    public AsyncPlayerChatListener(String token, String channelId) {
        this.token = token;
        bot = new DiscordBot(token, channelId);
        bot.sendMessage("`MineChat v0.1 is connected to discord.`");
    }

    // TODO: Handle `Event.isAsynchronous()` properly.
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (event != null) {
            String message = "**" + event.getPlayer().getPlayerListName() + ":** " + event.getMessage();
            bot.sendMessage(message);
        } else {
            System.out.println("Null AsyncPlayerChatEvent passed.");
        }
    }


}
