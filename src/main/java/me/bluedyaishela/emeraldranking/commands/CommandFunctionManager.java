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
}
