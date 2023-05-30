package me.bluedyaishela.emeraldranking;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class EmeraldRanking extends JavaPlugin {
    public FileConfiguration config;

    @Override
    public void onEnable() {
        this.load();
    }

    public void load() {
        this.loadConfig();
        this.useCommands();
    }

    private void useCommands() {
        Commands commands = new Commands(this);
        this.getCommand("emeraldranking").setExecutor(commands);
        this.getCommand("emeraldranking").setTabCompleter(commands);
    }

    private void loadConfig() {
        ConfigLoader configLoader = new ConfigLoader(this);
        configLoader.loadConfiguration();
    }

    @Override
    public void onDisable() {
    }
}
