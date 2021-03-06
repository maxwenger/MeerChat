package net.seasharp.meerchat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.bukkit.Bukkit.getServer;

public class PlayerCommandListener implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        Plugin plugin = getServer().getPluginManager().getPlugin("MeerChat");
        Player senderPlayer = getServer().getPlayer(sender.getName());

        // If the command was completed by the user.
        if (senderPlayer != null) {
            senderPlayer.sendMessage("§o[MeerChat is being reloaded - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]§o");

            restartPlugin(plugin);

            senderPlayer.sendMessage("§o[MeerChat has been reloaded - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]§o");
        }

        // If the command was completed by the console.
        else {
            Bukkit.broadcastMessage("[Server] §o[MeerChat is being reloaded - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]§o");

            restartPlugin(plugin);

            Bukkit.broadcastMessage("[Server] §o[MeerChat has been reloaded - " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "]§o");
        }

        return true;
    }

    private void restartPlugin(Plugin plugin) {
        // Since there isn't a reload() function, I'll disable and enable it again. This reloads the config as well!
        getServer().getPluginManager().disablePlugin(plugin);
        getServer().getPluginManager().enablePlugin(plugin);
    }
}
