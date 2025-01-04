package com.landonbakken.modded921;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * modded921 java plugin
 */
public class Plugin extends JavaPlugin
{
  public static Logger LOGGER=Logger.getLogger("modded921");
  
  public static ConfigLoader configLoader = new ConfigLoader();

  public void onEnable()
  {
    LOGGER.info("Modded921 Starting");

    LOGGER.info("Loading Special weapon config...");
    configLoader.loadConfigs();
    
    LOGGER.info("Registering commands...");
    SpecialItems specialItems = new SpecialItems();
    getCommand("specialItem").setTabCompleter(specialItems);
    getCommand("specialItem").setExecutor(specialItems);
    OtherCommands otherCommands = new OtherCommands();
    getCommand("howdy").setTabCompleter(otherCommands);
    getCommand("howdy").setExecutor(otherCommands);

    LOGGER.info("Registering events...");
    PlayerInteractions playerInteractions = new PlayerInteractions();
    getServer().getPluginManager().registerEvents(playerInteractions, this);
    
    LOGGER.info("Modded921 Enabled!\n");
  }

  public void onDisable()
  {
    LOGGER.info("Modded921 Disabled");
  }
}
