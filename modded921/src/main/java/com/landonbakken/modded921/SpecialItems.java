package com.landonbakken.modded921;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;


public class SpecialItems implements CommandExecutor, TabCompleter{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        //check if the message was from the player
        if(sender instanceof Player){
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

            return true;
        }
        
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestions = new ArrayList<>();
        
        if (args.length == 1) { // First argument
            suggestions.add("axe");
            suggestions.add("sword");
            //suggestions.add("wand");
            //suggestions.add("other");
        } else if (args.length == 2) { // Second argument
            if (args[0].equals("axe")) {
                suggestions.add("thorsAxe");
            }
            else if (args[0].equals("sword")) {
                suggestions.add("womboCombo");
                //suggestions.add("lightnightKatana");
            }
            else if (args[0].equals("wand")) {
                //suggestions.add("kineticWand");
            }
            else if (args[0].equals("other")) {
                //suggestions.add("fists");
            }
        }

        //filter with what the user has entered so far
        suggestions.stream()
            .filter(option -> option.toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
            .toList();

        return suggestions; // Return filtered list or unfiltered
    }
}
