package net.seasharp.meerchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayerCommandListener implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        return true;
    }
}
