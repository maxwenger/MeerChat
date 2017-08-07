package net.seasharp.minechat;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class DiscordCommandListener extends ListenerAdapter{

    // TODO: Add some basic authentication so that random users can't change server settings in case Discord messes up.
    // TODO: Maybe a list of valid user IDs in the plugin.yml file. Ooh, I like how that sounds.
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // It will reply to itself. This disables that from happening.
        if (event.getAuthor().isBot()) {
            return;
        }

        String command = event.getMessage().getContent();

        getLogger().info(event.getMessage().getContent() + " - " + event.getAuthor().getId());
        getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
    }
}
