package me.bluedyaishela.emeraldranking.commands;

import me.bluedyaishela.emeraldranking.utils.TypeChecker;
import org.bukkit.command.CommandSender;

public class CommandFunctionManager {
    public void helpCommand(CommandSender sender) {
        sender.sendMessage("Message d'aide");
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
        sender.sendMessage("Toutes vos émeraudes ont été ajoutées au classement.");
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
