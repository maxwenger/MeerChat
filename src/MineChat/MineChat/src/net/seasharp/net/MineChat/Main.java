package net.seasharp.net.MineChat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class Main extends JavaPlugin implements Listener{
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("======================== It Works! ========================");
    }

    @Override
    public void onDisable() {

    }

    // Sample - writes to the console when a player joins the server.
    @EventHandler
    public void onLogin(PlayerLoginEvent event) throws InterruptedException {
        getLogger().log(Level.INFO, "Player " + event.getPlayer().getName() + " is logging in!");
    }
}
