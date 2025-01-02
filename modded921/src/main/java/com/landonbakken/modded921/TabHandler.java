package com.landonbakken.modded921;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabHandler implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestions = new ArrayList<>();
        
        if(command.getName().equals("specialItem")){
            if (args.length == 1) { // First argument
                suggestions.add("axe");
                suggestions.add("sword");
                suggestions.add("wand");
                suggestions.add("other");
            } else if (args.length == 2) { // Second argument
                if (args[0].equals("axe")) {
                    suggestions.add("thorsAxe");
                }
                else if (args[0].equals("sword")) {
                    suggestions.add("wamboCombo");
                    suggestions.add("lightnightKatana");
                }
                else if (args[0].equals("wand")) {
                    suggestions.add("kineticWand");
                }
                else if (args[0].equals("other")) {
                    suggestions.add("fists");
                }
            }
        }

        //filter with what the user has entered so far
        suggestions.stream()
            .filter(option -> option.toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
            .toList();

        return suggestions; // Return filtered list or unfiltered
    }
}