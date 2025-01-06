package com.landonbakken.modded921;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.ChatColor;


import java.util.ArrayList;
import java.util.List;


public class OtherCommands implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return false;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("howdy")) {
            int zombieCount = 3; // Default number of zombies

            if (args.length == 1) {
                try {
                    zombieCount = Integer.parseInt(args[0]);
                    if (zombieCount < 1) {
                        player.sendMessage(ChatColor.RED + "You must spawn at least 1 zombie.");
                        return true;
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Please enter a valid number.");
                    return true;
                }
            }

            spawnZombies(player, zombieCount);
            player.sendMessage(ChatColor.GREEN + "Spawned " + zombieCount + " zombie(s) around you. Howdy!");
            return true;
        }

        return false;
    }

    private void spawnZombies(Player player, int count) {
        Location playerLocation = player.getLocation();

        for (int i = 0; i < count; i++) {
            double offsetX = (Math.random() * 6) - 3; // Random offset between -3 and 3
            double offsetZ = (Math.random() * 6) - 3;

            Location spawnLocation = playerLocation.clone().add(offsetX, 0, offsetZ);
            player.getWorld().spawnEntity(spawnLocation, EntityType.ZOMBIE);
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) { 
        List<String> suggestions = new ArrayList<>();
        
        if(command.getName().equals("howdy")){} //do nothing

        //filter with what the user has entered so far
        suggestions.stream()
            .filter(option -> option.toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
            .toList();

        return suggestions; // Return filtered list or unfiltered
    }
}