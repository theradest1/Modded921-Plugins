package com.landonbakken.modded921;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigLoader {
    public FileConfiguration weaponConfig;

    private FileConfiguration loadConfig(String configFileName){
        InputStream configStream = getClass().getClassLoader().getResourceAsStream(configFileName + ".yml");

        if (configStream != null) {
            return YamlConfiguration.loadConfiguration(new InputStreamReader(configStream));
        } else {
            throw new IllegalStateException("Could not find weapons.yml in resources!");
        }
    }

    //put other configs in here
    public void loadConfigs(){
        weaponConfig = loadConfig("specialWeaponsConfig");
    }
}
