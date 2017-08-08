package net.seasharp.meerchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerLeaveListener implements Listener{


    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        String message = "*" + event.getPlayer().getPlayerListName() + " has left the server*";
        SubscribedChatBots.sendMessageAsync(message);
    }
}
