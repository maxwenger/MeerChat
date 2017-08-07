package net.seasharp.meerchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerLeaveListener implements Listener{
    private DiscordBot bot;

    public OnPlayerLeaveListener(DiscordBot bot) {
        this.bot = bot;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        String message = "*" + event.getPlayer().getDisplayName() + " has left the server*";
        bot.sendMessage(message);
    }
}
