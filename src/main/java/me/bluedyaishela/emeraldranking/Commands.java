package me.bluedyaishela.emeraldranking;

import me.bluedyaishela.emeraldranking.commands.CommandResponseManager;
import me.bluedyaishela.emeraldranking.utils.TypeChecker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands implements CommandExecutor, TabCompleter {

    private EmeraldRanking plugin;
    public Commands(EmeraldRanking plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0)
        {
            sender.sendMessage(CommandResponseManager.getEmeraldRanking());
            return true;
        }

        if (!(sender instanceof Player))
        {
            return false;
        }

        if (args.length == 1) {
            String subCommand = args[0];
            switch (subCommand.toLowerCase()) {
                case "help":
                    sender.sendMessage("Message d'aide");
                    return true;
                case "add":
                    sender.sendMessage("Merci de spécifier une valeur d'émeraudes à ajouter");
                    return true;
                case "default":
                    break;
            }
        }

        if (args.length == 2) {
            String firstArg = args[0];
            String secondArg = args[1];

            switch (firstArg.toLowerCase()) {
                case "add":
                    if (TypeChecker.isInteger(secondArg))
                    {
                        int intArg = Integer.parseInt(secondArg);
                        // Code permettant l'ajout des émeraudes
                        sender.sendMessage("Vos " + intArg + " émeraudes ont été ajoutées à votre classement");
                        return true;
                    }
                    return false;
                case "default":
                    return false;
            }
        }

        sender.sendMessage("Cette commande n'existe pas");
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> availableCommands = new ArrayList<>();

        switch (args.length) {
            case 1:
                availableCommands.addAll(Arrays.asList("help", "add", "addall", "leaderboard"));
                return this.getArgsComplete(args, availableCommands, 0);
            case 2:
                availableCommands.addAll(Arrays.asList("value", "none"));
                return this.getArgsComplete(args, availableCommands, 1);
        }
        return null;
    }

    public List<String> getArgsComplete(String[] args, List<String> availableCommands, int argsIndex) {
        List<String> completions = new ArrayList<>();
        String input = args[argsIndex].toLowerCase();

        for (String commandOption : availableCommands) {
            if (commandOption.startsWith(input)) {
                completions.add(commandOption);
            }
        }

        return completions;
    }
}
