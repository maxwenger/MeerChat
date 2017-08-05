package net.seasharp.minechat;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }

    public void onDisable() {

    }

}
