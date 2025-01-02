package com.landonbakken.modded921;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            if(command.getName().equals("specialItem")){
                String itemName = args[1];
                Player player = (Player) sender;
                player.sendMessage("Item requested: " + itemName);
            }
            return true;
        }
        return false;
    }
}
