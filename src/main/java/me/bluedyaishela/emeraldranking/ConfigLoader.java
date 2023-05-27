package me.bluedyaishela.emeraldranking;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ConfigLoader {
    private final EmeraldRanking plugin;
    private FileConfiguration config;

    public ConfigLoader(EmeraldRanking plugin) {
        this.plugin = plugin;
    }

    public void loadConfiguration() {
        loadFiles();
    }

   private void loadFiles() {
       File configFile = new File(plugin.getDataFolder(), "config.yml");
       File dataFile = new File(plugin.getDataFolder(), "data.yml");

       if(!configFile.exists())
       {
           plugin.saveDefaultConfig();
       }

       if(!dataFile.exists())
       {
           plugin.saveResource("data.yml", true);
       }

       this.config = plugin.getConfig();
   }

}
