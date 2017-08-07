package net.seasharp.meerchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {
    private DiscordBot bot;

    public AsyncPlayerChatListener(DiscordBot bot) {
        this.bot = bot;
    }

    // TODO: Handle `Event.isAsynchronous()` properly.
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = "**<" + event.getPlayer().getPlayerListName() + ">** " + event.getMessage();
        bot.sendMessage(message);
    }
}
