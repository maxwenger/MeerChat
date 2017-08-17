package net.seasharp.meerchat;

import java.util.ArrayList;

public class SubscribedChatBots {
    protected SubscribedChatBots() {}

    private static ArrayList<ChatBot> chatBots = new ArrayList<ChatBot>();

    public static void sendMessageAsync(String message) {
        final String msg = message;
        final ArrayList<ChatBot> bots = new ArrayList<ChatBot>(chatBots);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ChatBot c:bots) {
                    c.sendMessage(msg);
                }
            }
        }).start();
    }

    public static void subscribeChatBot(ChatBot bot) {
        chatBots.add(bot);
    }
}
