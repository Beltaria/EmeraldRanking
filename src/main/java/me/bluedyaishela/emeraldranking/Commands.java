package me.bluedyaishela.emeraldranking;

import me.bluedyaishela.emeraldranking.commands.CommandFunctionManager;
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

        CommandFunctionManager cmdFunction = new CommandFunctionManager();
        CommandResponseManager cmdResponse = new CommandResponseManager();

        if (args.length == 0)
        {
            sender.sendMessage(cmdResponse.getEmeraldRanking());
            return true;
        }

        if (!(sender instanceof Player))
        {
            return false;
        }
        /*
            - add {value} # Paramètre obligatoire
            - show {player} # Si pas de paramètres alors soi-même
            - leaderboard # Classement des joueurs ayant le plus d'émeraudes
            - addall # Ajoute toutes les émeraudes disponibles dans l'inventaire
            - help # Affiche le menu d'aide des commandes et plugin
         */

        String subCommand = args[0];
        switch (subCommand.toLowerCase()) {
            case "help":
                cmdFunction.helpCommand(sender);
                return true;
            case "add":
                return cmdFunction.addCommand(sender, args);
            case "addall":
                return cmdFunction.addAllCommand(sender, args);
            case "show":
                return cmdFunction.showCommand(sender, args);
            case "leaderboard":
                return cmdFunction.leaderboardCommand(sender, args);
            case "default":
                break;
        }

        sender.sendMessage(cmdResponse.getNoExist());
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> availableCommands = new ArrayList<>();

        switch (args.length) {
            case 1:
                availableCommands.addAll(Arrays.asList("help", "add", "addall", "leaderboard", "show"));
                return this.getArgsComplete(args, availableCommands, 0);
            case 2:
                availableCommands.addAll(Arrays.asList("value", "player"));
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
