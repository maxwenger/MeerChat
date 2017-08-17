package net.seasharp.meerchat;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static org.bukkit.Bukkit.getServer;

public class DiscordCommandListener extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // It will reply to itself. This disables that from happening.

        if (!event.getAuthor().isBot()) {
            String message = prepareMessage(event);
            getServer().broadcastMessage(message);
        }
    }

    private String prepareMessage(MessageReceivedEvent event) {
        String author = event.getAuthor().getName();
        String message = event.getMessage().getContent();

        return "§B§ODiscord §R" + author + ": " + message;
    }

}
