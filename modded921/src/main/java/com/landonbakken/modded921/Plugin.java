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
    LOGGER.info("modded921 enabled");
    getCommand("special_item").setExecutor(new CommandHandler());
  }

  public void onDisable()
  {
    LOGGER.info("modded921 disabled");
  }
}
