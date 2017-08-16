package net.seasharp.meerchat;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.TextChannel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DiscordBot implements ChatBot {

    private JDA jda;
    private String channelId;

    public DiscordBot(String token, String channelId) {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .buildBlocking();

            // Init the Discord chat event listener
            jda.addEventListener(new DiscordCommandListener());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.channelId = channelId;
        sendInitializationMessage();
    }

    @Override
    protected void finalize() throws Throwable {
        sendTerminationMessage();
        super.finalize();
    }

    private void sendInitializationMessage() {
        sendMessage("*[MeerChat v0.1 initialized - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]*");
    }

    private void sendTerminationMessage() {
        sendMessage("*[MeerChat v0.1 has stopped - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]*");
    }

    public void sendMessage(String message) {
        TextChannel channel = jda.getTextChannelById(channelId);
        channel.sendMessage(message).complete();
    }
}
