package net.seasharp.meerchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinListener implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String message = "*" + event.getPlayer().getPlayerListName() + " has joined the server*";
        SubscribedChatBots.sendMessageAsync(message);
    }
}
