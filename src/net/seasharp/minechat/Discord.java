package net.seasharp.minechat;

import com.google.common.util.concurrent.FutureCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;

import javax.annotation.Nullable;

public class Discord {
    private DiscordAPI api;

    public Discord(String token) {
        api = Javacord.getApi(token, true);

        api.connect(new FutureCallback<DiscordAPI>() {
            @java.lang.Override
            public void onSuccess(@Nullable DiscordAPI discordAPI) {

            }

            @java.lang.Override
            public void onFailure(java.lang.Throwable throwable) {

            }
        });
    }

}
