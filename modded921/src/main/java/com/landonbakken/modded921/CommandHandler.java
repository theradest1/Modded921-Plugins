package com.landonbakken.modded921;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        //check if the message was from the player
        if(sender instanceof Player){
            if(command.getName().equals("specialItem")){
                String itemName = args[1];
                Player player = (Player) sender;
                player.sendMessage("Item requested: " + itemName);
            }
            else if(command.getName().equals("howdy")){
                Player player = (Player) sender;
                Location location = player.getLocation();

                // Spawn 20 zombies around the player
                for (int i = 0; i < 20; i++) {
                    Location spawnLocation = location.clone().add(Math.random() * 10 - 5, 0, Math.random() * 10 - 5);
                    player.getWorld().spawnEntity(spawnLocation, EntityType.ZOMBIE);
                }

                player.sendMessage("20 zombies have been spawned! Good luck!");
            }

            return true;
        }
        
        return false;
    }
}
