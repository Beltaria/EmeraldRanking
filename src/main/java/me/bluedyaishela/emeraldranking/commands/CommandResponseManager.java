package me.bluedyaishela.emeraldranking.commands;

public class CommandResponseManager {
    private static final String pluginName = "§7[§aEmeraldRanking§7] §7» ";
    public String getEmeraldRanking() {
        return pluginName + "§rVous utilisez actuellement EmeraldRanking, " +
                "pour lister les commandes : §e/emeraldranking help";
    }

    public String getInvalid() {
        return  pluginName + "§cCette commande est invalide.";
    }

    public String getAdminPerm() {
        return pluginName + "§cVous ne disposez pas des permissions nécessaires " +
                "pour effectuer cette commande.";
    }

    public String getNoExist() {
        return pluginName + "§cCette commande n'existe pas.";
    }
}
