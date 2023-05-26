package me.bluedyaishela.emeraldranking;

import org.bukkit.plugin.java.JavaPlugin;

public final class EmeraldRanking extends JavaPlugin {

    @Override
    public void onEnable() {
        this.load();
    }

    public void load() {
        this.useCommands();
    }

    public void useCommands() {
        Commands commands = new Commands();
        this.getCommand("emeraldranking").setExecutor(commands);
        this.getCommand("emeraldranking").setTabCompleter(commands);
    }

    @Override
    public void onDisable() {
    }
}
