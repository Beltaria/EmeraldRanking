package me.bluedyaishela.emeraldranking;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {
    private final EmeraldRanking plugin;
    private FileConfiguration config;
    private final Map<String, Object> configData = new HashMap<>();
    private final Map<String, Object> langData = new HashMap<>();


    public ConfigLoader(EmeraldRanking plugin) {
        this.plugin = plugin;
    }

    public void loadConfiguration() {
        this.loadFiles();
        this.loadConfig();
//        this.loadConfig();
    }
    private void loadFiles()
    {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        File langFR = new File(plugin.getDataFolder(), "lang/messages_fr.yml");
        File langEN = new File(plugin.getDataFolder(), "lang/messages_en.yml");

        if(!configFile.exists()) plugin.saveDefaultConfig();

        if(!langFR.exists()) plugin.saveResource("lang/messages_fr.yml", true);

        if(!langEN.exists()) plugin.saveResource("lang/messages_en.yml", true);

        this.config = plugin.getConfig();
    }

    private void loadConfig()
    {
        this.configData.put("plugin_name", plugin.getConfig().getString("plugin_name"));
        this.configData.put("lang_file", plugin.getConfig().getString("lang_file"));

        System.out.println(this.getConfigLangFile());
    }

    private void langConfig()
    {

    }

    public String getConfigLangFile()
    {
        return (String) this.configData.get("lang_file");
    }
}
