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
       File langFile = new File(plugin.getDataFolder(), "lang/messages_fr.yml");

       if(!configFile.exists())
       {
           plugin.saveDefaultConfig();
       }

       if(!langFile.exists())
       {
           plugin.saveResource("lang/messages_fr.yml", true);
       }

       this.config = plugin.getConfig();
   }

}
