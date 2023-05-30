package me.bluedyaishela.emeraldranking.commands;

public class CommandResponseManager {
    private static final String pluginName = "§7[§aEmeraldRanking§7] §7» ";
    private static final String emeraldRanking = pluginName + "§rVous utilisez actuellement EmeraldRanking, " +
            "pour lister les commandes : §e/emeraldranking help";

    private static final String invalid = pluginName + "§cCette commande est invalide.";
    private static  final String adminPerm = pluginName + "§cVous ne disposez pas des permissions nécessaires " +
            "pour effectuer cette commande.";

    public static String getEmeraldRanking() {
        return emeraldRanking;
    }

    public static String getInvalid() {
        return invalid;
    }
}
