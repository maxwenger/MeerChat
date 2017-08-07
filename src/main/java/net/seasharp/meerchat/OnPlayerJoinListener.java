package net.seasharp.meerchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinListener implements Listener{
    private DiscordBot bot;

    public OnPlayerJoinListener(DiscordBot bot) {
        this.bot = bot;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String message = "*" + event.getPlayer().getPlayerListName() + " has joined the server*";
        bot.sendMessage(message);
    }
}
