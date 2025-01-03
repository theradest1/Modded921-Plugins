package com.landonbakken.modded921;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        //check if the message was from the player
        if(sender instanceof Player){
            if(command.getName().equals("specialItem")){
                String itemName = args[1];
                Player player = (Player) sender;

                FileConfiguration weaponConfig = Plugin.configLoader.weaponConfig;
                String displayName = weaponConfig.getString(itemName + ".displayName");
                Material itemType = Material.getMaterial(weaponConfig.getString(itemName + ".itemType"));
                
                // Create an iron sword
                ItemStack ironSword = new ItemStack(itemType);

                // Get the item meta and set the custom name
                ItemMeta meta = ironSword.getItemMeta();
                if (meta != null) {
                    meta.setDisplayName(displayName);
                    ironSword.setItemMeta(meta);
                }

                // Add the sword to the player's inventory
                player.getInventory().addItem(ironSword);
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
