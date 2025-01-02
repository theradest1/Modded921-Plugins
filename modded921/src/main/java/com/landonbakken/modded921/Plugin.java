package com.landonbakken.modded921;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * modded921 java plugin
 */
public class Plugin extends JavaPlugin
{
  public static Logger LOGGER=Logger.getLogger("modded921");

  public void onEnable()
  {
    LOGGER.info("Modded921 Starting");
    
    //commands
    LOGGER.info("Registering commands");
    
    getCommand("specialItem").setTabCompleter(new TabHandler());
    getCommand("howdy").setTabCompleter(new TabHandler());

    getCommand("specialItem").setExecutor(new CommandHandler());
    getCommand("howdy").setExecutor(new CommandHandler());
    
    LOGGER.info("Modded921 Enabled");
  }

  public void onDisable()
  {
    LOGGER.info("Modded921 Disabled");
  }
}
