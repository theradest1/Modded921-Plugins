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
    LOGGER.info("\nModded921 Starting");

    LOGGER.info("Loading Special weapon config...");
    configLoader.loadConfigs();
    
    LOGGER.info("Registering commands...");
    
    getCommand("specialItem").setTabCompleter(new TabHandler());
    getCommand("howdy").setTabCompleter(new TabHandler());

    getCommand("specialItem").setExecutor(new CommandHandler());
    getCommand("howdy").setExecutor(new CommandHandler());
    
    LOGGER.info("Modded921 Enabled!\n");
  }

  public void onDisable()
  {
    LOGGER.info("Modded921 Disabled");
  }
}
