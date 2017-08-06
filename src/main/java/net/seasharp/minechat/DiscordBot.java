package net.seasharp.minechat;


import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.TextChannel;

public class DiscordBot {

    private JDA jda;
    private String channelName;
    private int channelIndex;

    public DiscordBot(String token, String channelName, int channelIndex) {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .buildBlocking();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.channelName = channelName;
        this.channelIndex = channelIndex;
    }

    public void sendMessage(String message) {

        TextChannel channel = jda.getTextChannelsByName(channelName, true).get(channelIndex);
        channel.sendMessage(message).complete();
    }
}