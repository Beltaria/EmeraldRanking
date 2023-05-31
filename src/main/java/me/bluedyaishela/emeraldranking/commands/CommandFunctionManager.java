package me.bluedyaishela.emeraldranking.commands;

import me.bluedyaishela.emeraldranking.utils.CommandUtils;
import me.bluedyaishela.emeraldranking.utils.TypeChecker;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class CommandFunctionManager {
    private final CommandUtils commandUtils = new CommandUtils();
    public void helpCommand(CommandSender sender) {
        sender.sendMessage("Message d'aide");
    }
    public boolean reloadCommand(CommandSender sender) {
        if(sender.hasPermission("op"))
        {
            PluginManager pluginManager = Bukkit.getPluginManager();
            Plugin myPlugin = pluginManager.getPlugin("EmeraldRanking");
            if (myPlugin != null) {
                pluginManager.disablePlugin(myPlugin);
                pluginManager.enablePlugin(myPlugin);

                sender.sendMessage("Le plugin a été rechargé avec succès.");
                return true;
            } else {
                sender.sendMessage("Le plugin spécifié n'a pas été trouvé.");
                return false;
            }
        }
        sender.sendMessage("No perm");
        return false;
    }
    public boolean addCommand(CommandSender sender, String[] args) {
        switch (args.length) {
            case 1:
                sender.sendMessage("Merci de spécifier une valeur d'émeraudes à ajouter");
                return true;
            case 2:
                String argument = args[1];
                if (TypeChecker.isInteger(argument))
                {
                    int intArg = Integer.parseInt(argument);
                    int emeraldCount = commandUtils.getEmeraldCount(sender);

                    if (intArg > emeraldCount) {
                        sender.sendMessage("Vous ne possédez pas assez d'émeraudes ! En votre possession : " + emeraldCount);
                        return false;
                    }

                    // Code permettant l'ajout des émeraudes


                    sender.sendMessage("Vos " + intArg + " émeraudes ont été ajoutées à votre classement");
                    return true;
                }
                sender.sendMessage("Entrez un entier : /emeraldranking add {valeur}");
                return true;
        }
        return false;
    }

    public boolean addAllCommand(CommandSender sender, String[] args) {
        // Récupérer le nom d'émeraudes dans l'inventaire du joueur & ajouter
       int emeraldCount = commandUtils.getEmeraldCount(sender);

        // Affiche également le nouveau montant
        sender.sendMessage("Toutes vos émeraudes ont été ajoutées au classement." + emeraldCount);
        return false;
    }

    public boolean showCommand(CommandSender sender, String[] args) {
        // Affiche au joueur concerné en fonction des arguments
        switch (args.length) {
            case 1:
                sender.sendMessage("Vous avez X émeraudes.");
                return true;
            case 2:
                sender.sendMessage("Le joueur X possède X émeraudes et est classé Xème.");
                return true;
        }
        return false;
    }

    public boolean leaderboardCommand(CommandSender sender, String[] args) {
        // Affiche le classement des joueurs
        sender.sendMessage("Classement top joueurs :");
        return false;
    }
}
