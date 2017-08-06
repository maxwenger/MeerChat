package net.seasharp.minechat;


import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.TextChannel;

public class DiscordBot {

    private JDA jda;
    private String channelId;

    public DiscordBot(String token, String channelId) {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .buildBlocking();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.channelId = channelId;
    }

    public void sendMessage(String message) {
        TextChannel channel = jda.getTextChannelById(channelId);
        channel.sendMessage(message).complete();
    }
}
