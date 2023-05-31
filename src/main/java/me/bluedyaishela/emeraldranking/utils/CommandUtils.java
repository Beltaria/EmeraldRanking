package me.bluedyaishela.emeraldranking.utils;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandUtils {

    public Integer getEmeraldCount(CommandSender sender) {
        Player player = (Player) sender;
        int emeraldCount = 0;

        for (ItemStack item : player.getInventory().getContents())
        {
            if (item != null && item.getType() == Material.EMERALD)
            {
                emeraldCount += item.getAmount();
            }
        }
        return emeraldCount;
    }
}
