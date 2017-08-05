package net.seasharp.minechat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    // TODO: Handle `Event.isAsynchronous()` properly.
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Bukkit.broadcastMessage(event.getMessage());
    }
}
