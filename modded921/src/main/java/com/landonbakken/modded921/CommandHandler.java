package com.landonbakken.modded921;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equals("special_item") && sender instanceof Player){
            Player player = (Player) sender;
            String itemName = args.toString();
            player.sendMessage("Item requested: " + itemName);
            return true;
        }
        return false;
    }
}
