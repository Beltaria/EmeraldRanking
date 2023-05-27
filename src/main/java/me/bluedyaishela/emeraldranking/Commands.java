package me.bluedyaishela.emeraldranking;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0)
        {
            sender.sendMessage("Vous utilisez actuellement EmeraldRanking, pour lister les commandes : /emeraldranking help");
            return true;
        }

        if (!(sender instanceof Player))
        {
            return false;
        }

        if (args.length == 1) {
            String subCommand = args[0];
            if (subCommand.equalsIgnoreCase("help")) {
                sender.sendMessage("Message d'aide");
                return true;
            }
            if(subCommand.equalsIgnoreCase("add")) {
                sender.sendMessage("");
                return true;
            }
        }

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
